package cn.edu.usst.competitionweb.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
    // 启动项目后，访问 http://localhost:8080/swagger-ui/index.html 查看 API 文档
    // 启动项目后，访问 http://localhost:8080/v3/api-docs 查看 API json


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(Collections.singletonList(new Server().url("http://localhost:8080"))) // 设置服务器地址
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("花慧 API 文档") // API文档标题
                        .version("1.0.0") // API版本
                        .description("花慧 API 文档")); // API文档描述
    }
}