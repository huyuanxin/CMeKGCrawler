package yuanxin.knowledge.crawler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yuanxin.knowledge.crawler.util.CrawlerUtil;
import yuanxin.knowledge.crawler.util.ImportEntityUtil;
import yuanxin.knowledge.crawler.util.ImportRelationUtil;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class
KnowledgeCrawlerApplicationTests {

    //    @Autowired
//    ImportUtil importUtil;
    @Autowired
    ImportEntityUtil importEntityUtil;

    @Autowired
    ImportRelationUtil importRelationUtil;

//    @Test
//    void init() {
//        importUtil.init();
//    }
//
//
//    @Test
//    void insertAll() {
//        importUtil.insertAll();
//    }
//
//    @Test
//    void test() {
//        List<String> result = CrawlerUtil.getDiseaseJsonComponent("疾病", "并发症");
//        result.forEach(System.out::println);
//    }

    @Test
    void insertAllEntity() {
        importEntityUtil.insertAll();
    }

    @Test
    void insertAllRelation() {
        importRelationUtil.insertAllRelation();
    }

    @Test
    void getDiseaseJsonComponentToHashMap() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "并发症");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(System.out::println);
        }
    }

}
