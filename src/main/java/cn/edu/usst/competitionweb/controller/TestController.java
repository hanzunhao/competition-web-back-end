package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.pojo.TestPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public Result getTest() {
        try {
            log.info("接收到 GET 请求");
            return Result.success("GET 请求处理成功！");
        } catch (Exception e) {
            log.error("处理 GET 请求时发生错误：", e);
            return Result.error("GET 请求处理失败！");
        }
    }

    @PostMapping
    public Result postTest(@RequestBody TestPojo testPojo) {
        try {
            log.info("接收到 POST 请求，testPojo: " + testPojo);
            return Result.success("POST 请求处理成功！");
        } catch (Exception e) {
            log.error("处理 POST 请求时发生错误：", e);
            return Result.error("POST 请求处理失败！");
        }
    }

    @PutMapping
    public Result putTest(@RequestBody TestPojo testPojo) {
        try {
            log.info("接收到 PUT 请求，testPojo: " + testPojo);
            return Result.success("PUT 请求处理成功！");
        } catch (Exception e) {
            log.error("处理 PUT 请求时发生错误：", e);
            return Result.error("PUT 请求处理失败！");
        }
    }

    @DeleteMapping
    public Result deleteTest() {
        try {
            log.info("接收到 DELETE 请求");
            return Result.success("DELETE 请求处理成功！");
        } catch (Exception e) {
            log.error("处理 DELETE 请求时发生错误：", e);
            return Result.error("DELETE 请求处理失败！");
        }
    }
}
