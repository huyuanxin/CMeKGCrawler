package yuanxin.knowledge.crawler.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yuanxin.knowledge.crawler.repository.*;

import java.util.List;

/**
 * @author huyuanxin
 */
@Component
public class ImportUtil {

    final DiseaseRepository diseaseRepository;
    final DrugRepository drugRepository;
    final SymptomRepository symptomRepository;
    final TreatmentRepository treatmentRepository;
    final EntityRepository entityRepository;

    @Autowired
    public ImportUtil(DiseaseRepository diseaseRepository, DrugRepository drugRepository, SymptomRepository symptomRepository, TreatmentRepository treatmentRepository, EntityRepository entityRepository) {
        this.diseaseRepository = diseaseRepository;
        this.drugRepository = drugRepository;
        this.symptomRepository = symptomRepository;
        this.treatmentRepository = treatmentRepository;
        this.entityRepository = entityRepository;
    }

    void initComplication() {
        try {
            entityRepository.initComplication();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initDisease() {
        try {
            diseaseRepository.initDisease();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initDrug() {
        try {
            drugRepository.initDrug();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initSymptom() {
        try {
            symptomRepository.initSymptom();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initTreatment() {
        try {
            symptomRepository.initSymptom();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    public void init() {
        initDisease();
        initDrug();
        initSymptom();
        initTreatment();
        initComplication();
    }

    public void insertAllDisease() {
        List<String> diseaseNameList = CrawlerUtil.getNameList("疾病");
        for (String disease : diseaseNameList
        ) {
            if (diseaseRepository.isExits(disease) < 1) {
                try {
                    diseaseRepository.insertDisease(disease);
                    System.out.println("插入:" + disease + "进入neo4j");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }

            }
        }
    }

    public void insertAllDrug() {
        List<String> drugNameList = CrawlerUtil.getNameList("药物");
        for (String drug : drugNameList
        ) {
            if (drugRepository.isExits(drug) < 1) {
                try {
                    drugRepository.insertDrug(drug);
                    System.out.println("插入:" + drug + "进入neo4j");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }

            }
        }
    }

    public void insertAllSymptom() {
        List<String> symptomNameList = CrawlerUtil.getNameList("症状");
        for (String symptom : symptomNameList
        ) {
            if (symptomRepository.isExits(symptom) < 1) {
                try {
                    symptomRepository.insertSymptom(symptom);
                    System.out.println("插入:" + symptom + "进入neo4j");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    public void insertAllTreatment() {
        List<String> treatmentNameList = CrawlerUtil.getNameList("诊疗");
        for (String treatment : treatmentNameList
        ) {
            if (treatmentRepository.isExits(treatment) < 1) {
                try {
                    treatmentRepository.insertTreatment(treatment);
                    System.out.println("插入:" + treatment + "进入neo4j");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    void insertAllComplication() {
        // 未完成的
        List<String> complicationNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "并发症");
        for (String complication : complicationNameList
        ) {
            if (diseaseRepository.isExits(complication) < 1) {
                try {
                    entityRepository.insertComplication(complication);
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    public void insertAll() {
        insertAllDisease();
        insertAllDrug();
        insertAllSymptom();
        insertAllTreatment();
        insertAllComplication();
    }


}
