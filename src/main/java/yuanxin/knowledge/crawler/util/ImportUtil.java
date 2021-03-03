package yuanxin.knowledge.crawler.util;

import org.springframework.beans.factory.annotation.Autowired;
import yuanxin.knowledge.crawler.service.DiseaseService;

import java.util.List;

/**
 * @author huyuanxin
 */
public class ImportUtil {

    final DiseaseService diseaseService;

    @Autowired
    public ImportUtil(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }

    public void insertAllDisease() {
        List<String> diseaseNameList = CrawlerUtil.getNameList("疾病");
        diseaseNameList.forEach(this::insertDisease);
    }

    private void insertDisease(String diseaseName) {
        diseaseService.insertDisease(diseaseName);
        System.out.println("插入疾病:" + diseaseName + " 进入neo4j");
    }
}
