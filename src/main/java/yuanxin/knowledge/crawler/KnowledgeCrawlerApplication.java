package yuanxin.knowledge.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import yuanxin.knowledge.crawler.util.SaveFileUtil;

/**
 * @author huyuanxin
 */
@SpringBootApplication
public class KnowledgeCrawlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnowledgeCrawlerApplication.class, args);
        saveAll();
    }

    private static void saveOneByOne() {
        SaveFileUtil.saveFile("疾病");
        SaveFileUtil.saveFile("药物");
        SaveFileUtil.saveFile("症状");
        SaveFileUtil.saveFile("诊疗");
    }

    private static void saveAll() {
        SaveFileUtil.saveAll("疾病");
        SaveFileUtil.saveAll("药物");
        SaveFileUtil.saveAll("症状");
        SaveFileUtil.saveAll("诊疗");
    }
}
