package cn.edu.usst.competitionweb.service.impl;

import cn.edu.usst.competitionweb.config.DeepSeekConfig;
import cn.edu.usst.competitionweb.pojo.DeepSeekAnswer;
import cn.edu.usst.competitionweb.pojo.DeepSeekQuestion;
import cn.edu.usst.competitionweb.service.DeepSeekService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Slf4j
public class DeepSeekServiceImpl implements DeepSeekService {

    private final DeepSeekConfig deepSeekConfig;
    private final WebClient webClient;

    public DeepSeekServiceImpl(WebClient.Builder webClientBuilder, DeepSeekConfig deepSeekConfig) {
        this.webClient = webClientBuilder.baseUrl(deepSeekConfig.getApiUrl()).build();
        this.deepSeekConfig = deepSeekConfig;
    }

    @Override
    public DeepSeekAnswer chat(String question) {
        DeepSeekQuestion request = new DeepSeekQuestion();
        request.setModel("deepseek-chat");
        request.setMessages(List.of(new DeepSeekQuestion.Message("user", question)));

        log.info(String.valueOf(request));

        return webClient.post()
                .uri("/chat")
                .header("Authorization", "Bearer " + deepSeekConfig.getApiKey())
                .bodyValue(request)
                .retrieve()
                .bodyToMono(DeepSeekAnswer.class)
                .block();
    }
}