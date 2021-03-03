package yuanxin.knowledge.crawler.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author huyuanxin
 */
@SpringBootTest
class DiseaseServiceTest {
    @Autowired
    DiseaseService diseaseService;

    @Test
    void initDisease() {
        diseaseService.initDisease();
    }

    @Test
    void insertDisease() {
        diseaseService.insertDisease("心脏病");
    }

    @Test
    void count() {
        Long o = diseaseService.count("NICH");
        System.out.println(o);
    }
}