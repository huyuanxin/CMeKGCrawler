package yuanxin.knowledge.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import yuanxin.knowledge.crawler.util.ImportEntityUtil;
import yuanxin.knowledge.crawler.util.ImportRelationUtil;
import yuanxin.knowledge.crawler.util.SaveFileUtil;

import javax.annotation.PostConstruct;

/**
 * @author huyuanxin
 */
@SpringBootApplication
public class KnowledgeCrawlerApplication {

    final ImportEntityUtil importEntityUtil;
    final ImportRelationUtil importRelationUtil;

    static ImportEntityUtil staticImportEntityUtil = null;
    static ImportRelationUtil staticImportRelationUtil = null;

    @Autowired
    public KnowledgeCrawlerApplication(ImportEntityUtil importEntityUtil, ImportRelationUtil importRelationUtil) {
        this.importEntityUtil = importEntityUtil;
        this.importRelationUtil = importRelationUtil;
    }

    @PostConstruct
    void init() {
        staticImportEntityUtil = importEntityUtil;
        staticImportRelationUtil = importRelationUtil;
    }

    public static void main(String[] args) {
        SpringApplication.run(KnowledgeCrawlerApplication.class, args);
        // SaveFileUtil.saveAllToJson();
        staticImportEntityUtil.init();
        staticImportEntityUtil.insertAll();
        staticImportRelationUtil.insertAllRelation();
    }
}
