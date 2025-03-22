package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.anno.PrintOperateLog;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/page_3")
@Tag(name = "DeepSeek 接口", description = "DeepSeek 相关接口")  // 描述该Controller的功能
@Slf4j
public class DeepSeekController {

    // 从配置文件中注入 Deepseek API 的密钥
    @Value("${ai.config.deepseek.apiKey}")
    private String API_KEY;

    // 从配置文件中注入 Deepseek API 的基础 URL
    @Value("${ai.config.deepseek.baseUrl}")
    private String API_URL;

    // 用于保存每个用户的对话历史，键为用户 ID，值为对话消息列表
    private final Map<String, List<Map<String, String>>> sessionHistory = new ConcurrentHashMap<>();

    // 创建一个可缓存的线程池，用于处理异步任务
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    // Jackson 的 ObjectMapper，用于 JSON 的序列化和反序列化
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 处理 POST 请求，接收用户的问题并返回流式响应
     *
     * @param question 用户的问题
     * @return SseEmitter 对象，用于流式传输响应
     */
    @PostMapping(value = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @Operation(summary = "与 AI 对话", description = "接收用户的问题并返回流式响应")
    @PrintOperateLog
    public SseEmitter chat(
            @Parameter(description = "用户的问题", required = true) @RequestBody String question) {
        System.out.println("Base URL: " + API_URL);

        // 假设用户 ID 为 "1"，实际应用中可以从 token 中解析出用户 ID
        String userId = "1";

        // 创建一个 SseEmitter 对象，用于流式传输响应
        SseEmitter emitter = new SseEmitter(-1L);

        // 提交任务到线程池中异步执行
        executorService.execute(() -> {
            try {
                log.info("流式回答开始, 问题: {}", question);

                // 获取当前用户的对话历史，如果不存在则创建一个新的列表
                List<Map<String, String>> messages = sessionHistory.getOrDefault(userId, new ArrayList<>());

                // 添加用户的新问题到对话历史
                Map<String, String> userMessage = new HashMap<>();
                userMessage.put("role", "user");
                userMessage.put("content", question);

                // 添加系统消息到对话历史
                Map<String, String> systemMessage = new HashMap<>();
                systemMessage.put("role", "system");
                systemMessage.put("content", "花慧AI助手");

                messages.add(userMessage);
                messages.add(systemMessage);

                // 调用 Deepseek API
                try (CloseableHttpClient client = HttpClients.createDefault()) {
                    HttpPost request = new HttpPost(API_URL);
                    request.setHeader("Content-Type", "application/json");
                    request.setHeader("Authorization", "Bearer " + API_KEY);

                    // 构建请求体
                    Map<String, Object> requestMap = new HashMap<>();
                    requestMap.put("model", "deepseek-chat"); // 使用的模型
                    requestMap.put("messages", messages); // 包含对话历史
                    requestMap.put("stream", true); // 启用流式响应

                    String requestBody = objectMapper.writeValueAsString(requestMap);
                    request.setEntity(new StringEntity(requestBody, StandardCharsets.UTF_8));

                    // 执行请求并处理响应
                    try (CloseableHttpResponse response = client.execute(request);
                         BufferedReader reader = new BufferedReader(
                                 new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8))) {
                        StringBuilder aiResponse = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.startsWith("data: ")) {
                                String jsonData = line.substring(6);
                                if ("[DONE]".equals(jsonData)) {
                                    break; // 流式响应结束
                                }
                                JsonNode node = objectMapper.readTree(jsonData);
                                String content = node.path("choices")
                                        .path(0)
                                        .path("delta")
                                        .path("content")
                                        .asText("");
                                if (!content.isEmpty()) {
                                    emitter.send(content); // 发送流式响应
                                    aiResponse.append(content); // 收集 AI 的回复
                                }
                            }
                        }

                        // 将 AI 的回复添加到对话历史
                        Map<String, String> aiMessage = new HashMap<>();
                        aiMessage.put("role", "assistant");
                        aiMessage.put("content", aiResponse.toString());
                        messages.add(aiMessage);

                        // 更新会话状态
                        sessionHistory.put(userId, messages);

                        log.info("流式回答结束, 问题: {}", question);
                        emitter.complete(); // 完成流式响应
                    }
                } catch (Exception e) {
                    log.error("处理 Deepseek 请求时发生错误", e);
                    emitter.completeWithError(e); // 发生错误时结束流式响应
                }
            } catch (Exception e) {
                log.error("处理 Deepseek 请求时发生错误", e);
                emitter.completeWithError(e); // 发生错误时结束流式响应
            }
        });
        return emitter;
    }
}