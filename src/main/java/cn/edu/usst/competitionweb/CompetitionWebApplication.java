package cn.edu.usst.competitionweb;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan  // 确保自动扫描过滤器
public class CompetitionWebApplication {
    public static void main(String[] args) {
        // 加载 .env 文件
        Dotenv dotenv = Dotenv.configure().load();

        // 将 .env 中的变量添加到系统环境变量中
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

        // 启动 Spring Boot 应用
        SpringApplication.run(CompetitionWebApplication.class, args);
    }
}