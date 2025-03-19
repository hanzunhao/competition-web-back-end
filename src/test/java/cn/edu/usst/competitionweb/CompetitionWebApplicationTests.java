package cn.edu.usst.competitionweb;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class CompetitionWebApplicationTests {
    @Value("${ai.config.deepseek.apiKey}")
    String key;

    @Value("${ai.config.deepseek.baseUrl}")
    String url;

    @Test
    void test() {
        System.out.println(key);
        System.out.println(url);
    }
}
