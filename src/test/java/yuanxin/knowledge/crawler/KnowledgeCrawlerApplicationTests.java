package yuanxin.knowledge.crawler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yuanxin.knowledge.crawler.util.CrawlerUtil;
import yuanxin.knowledge.crawler.util.ImportUtil;

import java.util.List;

@SpringBootTest
class KnowledgeCrawlerApplicationTests {

    @Autowired
    ImportUtil importUtil;

    @Test
    void init() {
        importUtil.init();
    }


    @Test
    void insertAll() {
        importUtil.insertAll();
    }

    @Test
    void test() {
        List<String> result = CrawlerUtil.getDiseaseJsonComponent("疾病", "并发症");
        result.forEach(System.out::println);
    }

}
