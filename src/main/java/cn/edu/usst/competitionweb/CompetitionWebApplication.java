package cn.edu.usst.competitionweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan  // 确保自动扫描过滤器
public class CompetitionWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompetitionWebApplication.class, args);
    }

}
