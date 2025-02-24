package cn.edu.usst.competitionweb;

import cn.edu.usst.competitionweb.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class CompetitionWebApplicationTests {

    @Autowired
    VideoController videoController;

    @Test
    void testGetVideo() {
        Result result = videoController.getVideo();
        log.info(result.toString());
    }
}
