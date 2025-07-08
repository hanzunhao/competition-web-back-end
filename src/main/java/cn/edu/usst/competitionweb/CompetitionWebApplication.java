package cn.edu.usst.competitionweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {
        "cn.edu.usst.competitionweb"
})
@RestController
@EnableTransactionManagement
public class CompetitionWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompetitionWebApplication.class, args);
    }
}