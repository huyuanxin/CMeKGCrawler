package yuanxin.knowledge.crawler.util;

import org.springframework.beans.factory.annotation.Autowired;
import yuanxin.knowledge.crawler.repository.*;

import java.util.HashMap;
import java.util.List;

public class ImportRelationUtil {


    //疾病
    final DiseaseRepository diseaseRepository;
    final EntityRepository entityRepository;//并发症
    final SymptomRepository symptomRepository;

    final PathologicalTypeRepository pathologicalTypeRepository;
    final TreatmentRepository treatmentRepository;
    final DiagnosisRepository diagnosisRepository;
    final PathophysiologyRepository pathophysiologyRepository;
    final DiseaseSiteRepository diseaseSiteRepository;
    final DepartmentRepository departmentRepository;
    final MultipleGroupsRepository multipleGroupsRepository;
    final CauseRepository causeRepository;
    final PrognosticSurvivalTimeRepository prognosticSurvivalTimeRepository;
    final HighRiskFactorsRepository highRiskFactorsRepository;
    final DrugRepository drugRepository;
    final PrognosisRepository prognosisRepository;
    final AttributeRepository attributeRepository;
    final DiseaseRateRepository diseaseRateRepository;
    final DrugTherapyRepository drugTherapyRepository;
    final AdjuvantTherapyRepository adjuvantTherapyRepository;
    final OperationRepository operationRepository;
    final PathogenesisRepository pathogenesisRepository;
    final SymptomAndSignRepository symptomAndSignRepository;


    //症状
    final CheckRepository checkRepository;
    final RelatedDiseaseRepository relatedDiseaseRepository;
    final RelatedSymptomRepository relatedSymptomRepository;
    final InfectiousRepository infectiousRepository;
    final RelatedToRepository relatedToRepository;
    final AuxiliaryExaminationRepository auxiliaryExaminationRepository;
    final StageRepository stageRepository;
    final TreatmentProgramsRepository treatmentProgramsRepository;
    final PreventionRepository preventionRepository;
    final SpreadWayRepository spreadWayRepository;

    //药物
    final TypeRepository typeRepository;
    final PrecautionsRepository precautionsRepository;
    final ContraindicationsRepository contraindicationsRepository;
    final SubjectRepository subjectRepository;
    final IngredientsRepository ingredientsRepository;
    final OTCRepository OTCRepository;
    final AdverseReactionsRepository adverseReactionsRepository;
    final IndicationsRepository indicationsRepository;

    //诊疗
    final CheckSubjectRepository checkSubjectRepository;
    final DiseaseRelationRepository diseaseRelationRepository;


    public ImportRelationUtil(DiseaseRepository diseaseRepository,
                              SymptomRepository symptomRepository,
                              EntityRepository entityRepository,
                              PathologicalTypeRepository pathologicalTypeRepository,
                              TreatmentRepository treatmentRepository,
                              DiagnosisRepository diagnosisRepository,
                              PathophysiologyRepository pathophysiologyRepository,
                              DiseaseSiteRepository diseaseSiteRepository,
                              DepartmentRepository departmentRepository,
                              MultipleGroupsRepository multipleGroupsRepository,
                              CauseRepository causeRepository,
                              PrognosticSurvivalTimeRepository prognosticSurvivalTimeRepository,
                              HighRiskFactorsRepository highRiskFactorsRepository,
                              PrognosisRepository prognosisRepository,
                              AttributeRepository attributeRepository,
                              DiseaseRateRepository diseaseRateRepository,
                              DrugRepository drugRepository,
                              DrugTherapyRepository drugTherapyRepository,
                              AdjuvantTherapyRepository adjuvantTherapyRepository,
                              OperationRepository operationRepository,
                              PathogenesisRepository pathogenesisRepository,
                              CheckRepository checkRepository,
                              RelatedDiseaseRepository relatedDiseaseRepository,
                              RelatedSymptomRepository relatedSymptomRepository,
                              InfectiousRepository infectiousRepository,
                              RelatedToRepository relatedToRepository,
                              SymptomAndSignRepository symptomAndSignRepository,
                              AuxiliaryExaminationRepository auxiliaryExaminationRepository,
                              StageRepository stageRepository,
                              TreatmentProgramsRepository treatmentProgramsRepository,
                              PreventionRepository preventionRepository,
                              SpreadWayRepository spreadWayRepository,
                              TypeRepository typeRepository,
                              PrecautionsRepository precautionsRepository,
                              ContraindicationsRepository contraindicationsRepository,
                              SubjectRepository subjectRepository,
                              IngredientsRepository ingredientsRepository,
                              OTCRepository OTCRepository,
                              AdverseReactionsRepository adverseReactionsRepository,
                              IndicationsRepository indicationsRepository,
                              CheckSubjectRepository checkSubjectRepository,
                              DiseaseRelationRepository diseaseRelationRepository) {
        //疾病
        this.diseaseRepository = diseaseRepository;
        this.entityRepository = entityRepository;
        this.symptomRepository = symptomRepository;
        this.pathologicalTypeRepository = pathologicalTypeRepository;
        this.treatmentRepository = treatmentRepository;
        this.diagnosisRepository = diagnosisRepository;
        this.pathophysiologyRepository = pathophysiologyRepository;
        this.diseaseSiteRepository = diseaseSiteRepository;
        this.departmentRepository = departmentRepository;
        this.multipleGroupsRepository = multipleGroupsRepository;
        this.causeRepository = causeRepository;
        this.prognosticSurvivalTimeRepository = prognosticSurvivalTimeRepository;
        this.highRiskFactorsRepository = highRiskFactorsRepository;
        this.prognosisRepository = prognosisRepository;
        this.attributeRepository = attributeRepository;
        this.diseaseRateRepository = diseaseRateRepository;
        this.drugRepository = drugRepository;
        this.drugTherapyRepository = drugTherapyRepository;
        this.adjuvantTherapyRepository = adjuvantTherapyRepository;
        this.operationRepository = operationRepository;
        this.pathogenesisRepository = pathogenesisRepository;

        //症状
        this.checkRepository = checkRepository;
        this.relatedDiseaseRepository = relatedDiseaseRepository;
        this.relatedSymptomRepository = relatedSymptomRepository;
        this.infectiousRepository = infectiousRepository;
        this.relatedToRepository = relatedToRepository;
        this.symptomAndSignRepository = symptomAndSignRepository;
        this.auxiliaryExaminationRepository = auxiliaryExaminationRepository;
        this.stageRepository = stageRepository;
        this.treatmentProgramsRepository = treatmentProgramsRepository;
        this.preventionRepository = preventionRepository;
        this.spreadWayRepository = spreadWayRepository;

        //药物
        this.typeRepository = typeRepository;
        this.precautionsRepository = precautionsRepository;
        this.contraindicationsRepository = contraindicationsRepository;
        this.subjectRepository = subjectRepository;
        this.ingredientsRepository = ingredientsRepository;
        this.OTCRepository = OTCRepository;
        this.adverseReactionsRepository = adverseReactionsRepository;
        this.indicationsRepository = indicationsRepository;

        //诊疗
        this.checkSubjectRepository = checkSubjectRepository;
        this.diseaseRelationRepository = diseaseRelationRepository;
    }

    //疾病
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


    //关系-并发症
    void insertRelComplicationInDisease(String diseaseName, String name) {
        if (diseaseRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelComplicationDTD(diseaseName, name);
        } else if (symptomRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelComplicationDTS(diseaseName, name);
        } else if (entityRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelComplicationDTC(diseaseName, name);
        }
    }

    void getRelComplicationInDisease() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "并发症");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelComplicationInDisease(key, it));
        }
    }

    //关系-病理生理
    void insertRelPathophysiologyInDisease(String diseaseName, String name) {
        if (diseaseRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelPathophysiologyDTD(diseaseName, name);
        } else if (symptomRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelPathophysiologyDTS(diseaseName, name);
        } else if (pathophysiologyRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelPathophysiologyDTP(diseaseName, name);
        }
    }

    void getRelPathophysiologyInDisease() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "病理生理");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelPathophysiologyInDisease(key, it));
        }
    }

    //关系-发病部位
    void insertRelDiseaseSiteInDisease(String diseaseName, String name) {
        if (diseaseRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelDiseaseSiteDTD(diseaseName, name);
        } else if (symptomRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelDiseaseSiteDTS(diseaseName, name);
        } else if (diseaseSiteRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelDiseaseSiteDTP(diseaseName, name);
        }
    }

    void getRelDiseaseSiteInDisease() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "发病部位");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelDiseaseSiteInDisease(key, it));
        }
    }

    //关系-所属科室
    void insertRelDepartmentInDisease(String diseaseName, String name) {
        if (departmentRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelDepartmentDTD(diseaseName, name);
        }
    }

    void getRelDepartmentInDisease() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "所属科室");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelDepartmentInDisease(key, it));
        }
    }

    //关系-多发群体
    void insertRelMultipleGroupsInDisease(String diseaseName, String name) {
        if (multipleGroupsRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelMultipleGroupsDTM(diseaseName, name);
        }
    }

    void getRelMultipleGroupsInDisease() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "多发群体");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelMultipleGroupsInDisease(key, it));
        }
    }

    //关系-病因
    void insertRelCauseInDisease(String diseaseName, String name) {
        if (diseaseRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelCauseDTD(diseaseName, name);
        } else if (causeRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelCauseDTC(diseaseName, name);
        }
    }

    void getRelCauseInDisease() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "病因");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelCauseInDisease(key, it));
        }
    }


    //关系-预后生存时间
    void insertRelPrognosticSurvivalTimeInDisease(String diseaseName, String name) {
        if (prognosticSurvivalTimeRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelPrognosticSurvivalTimeDTP(diseaseName, name);
        }
    }

    void getRelPrognosticSurvivalTimeInDisease() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "预后生存时间");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelPrognosticSurvivalTimeInDisease(key, it));
        }
    }

    //关系-高危因素
    void insertRelHighRiskFactorsInDisease(String diseaseName, String name) {
        if (highRiskFactorsRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelHighRiskFactorsDTH(diseaseName, name);
        }
    }

    void getRelHighRiskFactorsInDisease() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "高危因素");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelHighRiskFactorsInDisease(key, it));
        }
    }

    //关系-相关疾病
    void insertRelRelatedDiseaseInDisease(String diseaseName, String name) {
        if (relatedDiseaseRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelRelatedDiseaseDTR(diseaseName, name);
        } else if (diseaseRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelRelatedDiseaseDTD(diseaseName, name);
        }
    }

    void getRelRelatedDiseaseInDisease() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "相关疾病");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelRelatedDiseaseInDisease(key, it));
        }
    }

    //关系-相关症状
    void insertRelRelatedSymptomInDisease(String diseaseName, String name) {
        if (relatedSymptomRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelRelatedSymptomDTR(diseaseName, name);
        } else if (symptomRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelRelatedSymptomDTS(diseaseName, name);
        }
    }

    void getRelRelatedSymptomInDisease() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "相关症状");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelRelatedSymptomInDisease(key, it));
        }
    }

    //关系-治疗方案
    void insertRelTreatmentProgramsInDisease(String diseaseName, String name) {
        if (adjuvantTherapyRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelTreatmentProgramsDTA(diseaseName, name);
        } else if (drugTherapyRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelTreatmentProgramsDTU(diseaseName, name);
        } else if (operationRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelTreatmentProgramsDTO(diseaseName, name);
        } else if (drugRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelTreatmentProgramsDTD(diseaseName, name);
        } else if (treatmentRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelTreatmentProgramsDTT(diseaseName, name);
        } else if (checkRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelTreatmentProgramsDTC(diseaseName, name);
        } else if (auxiliaryExaminationRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelTreatmentProgramsDTE(diseaseName, name);
        }
    }

    void getRelTreatmentProgramsInDisease() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "治疗方案");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelTreatmentProgramsInDisease(key, it));
        }
    }

    /**
     * 插入临床症状及体征关系
     **/
    void insertRelSymptomAndSignInDisease(String diseaseName, String name) {
        if (diseaseRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelSymptomAndSignDTD(diseaseName, name);
        } else if (symptomRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelSymptomAndSignDTS(diseaseName, name);
        } else if (symptomAndSignRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelSymptomAndSignDTSAS(diseaseName, name);
        }
    }

    void getRelSymptomAndSignInDisease() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "临床症状及体征");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelSymptomAndSignInDisease(key, it));
        }
    }

    /**
     * 插入预后状况关系
     **/
    void insertRelPrognosisInDisease(String diseaseName, String name) {
        if (prognosisRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelPrognosis(diseaseName, name);
        }
    }

    void getRelPrognosis() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "预后状况");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelPrognosisInDisease(key, it));
        }
    }

    /**
     * 插入发病率关系
     **/
    void insertRelDiseaseRateInDisease(String diseaseName, String name) {
        if (diseaseRateRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelDiseaseRateDTDR(diseaseName, name);
        } else if (attributeRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelDiseaseRateDTA(diseaseName, name);
        }
    }

    void getRelDiseaseRate() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "发病率");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelDiseaseRateInDisease(key, it));
        }
    }

    /**
     * 插入药物治疗关系
     **/
    void insertRelDrugTherapyInDisease(String diseaseName, String name) {
        if (drugRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelDrugTherapyDTD(diseaseName, name);
        } else if (drugTherapyRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelDrugTherapyDTDT(diseaseName, name);
        }
    }

    void getRelDrugTherapy() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "药物治疗");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelDrugTherapyInDisease(key, it));
        }
    }

    /**
     * 插入临辅助治疗关系
     **/
    void insertRelAdjuvantTherapyInDisease(String diseaseName, String name) {
        if (treatmentRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelAdjuvantTherapyDTT(diseaseName, name);
        } else if (adjuvantTherapyRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelAdjuvantTherapyDTA(diseaseName, name);
        }
    }

    void getRelAdjuvantTherapy() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "辅助治疗");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelAdjuvantTherapyInDisease(key, it));
        }
    }

    /**
     * 插入手术治疗关系
     **/
    void insertRelOperationInDisease(String diseaseName, String name) {
        if (treatmentRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelOperationDTT(diseaseName, name);
        } else if (operationRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelOperationDTO(diseaseName, name);
        }
    }

    void getRelOperation() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "手术治疗");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelOperationInDisease(key, it));
        }
    }

    /**
     * 插入发病机制关系
     **/
    void insertRelPathogenesisInDisease(String diseaseName, String name) {
        if (pathogenesisRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelPathogenesisDTO(diseaseName, name);
        }
    }

    void getRelPathogenesis() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "发病机制");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelPathogenesisInDisease(key, it));
        }
    }

    /**
     * 插入病理分型关系
     **/
    void insertRelPathologicalTypeInDisease(String diseaseName, String name) {
        if (pathologicalTypeRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelPathologicalTypeDTO(diseaseName, name);
        }
    }

    void getRelPathologicalType() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "病理分型");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelPathologicalTypeInDisease(key, it));
        }
    }

    /**
     * 插入鉴别诊断关系
     **/
    void insertRelDiagnosisInDisease(String diseaseName, String name) {
        if (treatmentRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelDiagnosisDTT(diseaseName, name);
        } else if (diagnosisRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelDiagnosisDTDI(diseaseName, name);
        }
    }

    void getRelDiagnosis() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "鉴别诊断");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelDiagnosisInDisease(key, it));
        }
    }


}
