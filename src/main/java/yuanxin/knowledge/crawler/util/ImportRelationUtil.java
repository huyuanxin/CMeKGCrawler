package yuanxin.knowledge.crawler.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yuanxin.knowledge.crawler.repository.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhangtingting
 * @author luhaoyi
 */
@Component
public class ImportRelationUtil {
    //疾病
    final DiseaseRepository diseaseRepository;
    //并发症
    final EntityRepository entityRepository;
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
    final SymptomRelationRepository symptomRelationRepository;
    final DrugRelationRepository drugRelationRepository;
    final TreatmentRelationRepository treatmentRelationRepository;

    @Autowired
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
                              DiseaseRelationRepository diseaseRelationRepository,
                              SymptomRelationRepository symptomRelationRepository,
                              DrugRelationRepository drugRelationRepository,
                              TreatmentRelationRepository treatmentRelationRepository) {
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
        this.symptomRelationRepository = symptomRelationRepository;
        this.drugRelationRepository = drugRelationRepository;
        this.treatmentRelationRepository = treatmentRelationRepository;
    }

    //关系：疾病-并发症
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

    //关系：疾病-病理生理
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

    //关系：疾病-发病部位
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

    //关系：疾病-所属科室
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

    //关系：疾病-多发群体
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

    //关系：疾病-病因
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


    //关系：疾病-预后生存时间
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

    //关系：疾病-高危因素
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

    //关系：疾病-相关疾病
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

    //关系：疾病-相关症状
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

    //关系:疾病-治疗方案
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
        } else if (treatmentProgramsRepository.isExits(name) > 0) {
            diseaseRelationRepository.insertRelTreatmentProgramsDTTP(diseaseName, name);
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

    void getRelPrognosisInDisease() {
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

    void getRelDiseaseRateInDisease() {
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

    void getRelDrugTherapyInDisease() {
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

    void getRelAdjuvantTherapyInDisease() {
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

    void getRelOperationInDisease() {
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

    void getRelPathogenesisInDisease() {
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

    void getRelPathologicalTypeInDisease() {
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

    void getRelDiagnosisInDisease() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("疾病", "鉴别诊断");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelDiagnosisInDisease(key, it));
        }
    }

    /**
     * 关系：症状-病因
     **/
    void insertRelCauseInSymptom(String symptomName, String name) {
        if (diseaseRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelCauseSTD(symptomName, name);
        } else if (causeRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelCauseSTC(symptomName, name);
        }
    }

    void getRelCauseInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "病因");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelCauseInSymptom(key, it));
        }
    }

    /**
     * 关系：症状-治疗方案
     **/
    void insertRelTreatmentProgramsInSymptom(String symptomName, String name) {
        if (adjuvantTherapyRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelTreatmentProgramsSTA(symptomName, name);
        } else if (drugTherapyRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelTreatmentProgramsSTU(symptomName, name);
        } else if (operationRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelTreatmentProgramsSTO(symptomName, name);
        } else if (drugRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelTreatmentProgramsSTD(symptomName, name);
        } else if (treatmentRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelTreatmentProgramsSTT(symptomName, name);
        } else if (checkRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelTreatmentProgramsSTC(symptomName, name);
        } else if (auxiliaryExaminationRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelTreatmentProgramsSTE(symptomName, name);
        } else if (treatmentProgramsRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelTreatmentProgramsSTTP(symptomName, name);
        }
    }

    void getRelTreatmentProgramsInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "治疗方案");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelTreatmentProgramsInSymptom(key, it));
        }
    }

    /**
     * 关系：症状-预防
     **/
    void insertRelPreventionInSymptom(String symptomName, String name) {
        if (preventionRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelPreventionSTP(symptomName, name);
        }
    }

    void getRelPreventionInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "预防");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelPreventionInSymptom(key, it));
        }
    }

    /**
     * 关系：症状-传播途径
     **/
    void insertRelSpreadWayInSymptom(String symptomName, String name) {
        if (spreadWayRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelSpreadWaySTSW(symptomName, name);
        }
    }

    void getRelSpreadWayInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "传播途径");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelSpreadWayInSymptom(key, it));
        }
    }

    /**
     * 关系：药物-成份
     **/
    void insertRelIngredientsInDrug(String drugName, String name) {
        if (ingredientsRepository.isExits(name) > 0) {
            drugRelationRepository.insertRelIngredientsDTI(drugName, name);
        }
    }

    void getRelIngredientsInDrug() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("药物", "成份");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelIngredientsInDrug(key, it));
        }
    }

    /**
     * 关系：药物-OTC类型
     **/
    void insertRelOTCInDrug(String drugName, String name) {
        if (OTCRepository.isExits(name) > 0) {
            drugRelationRepository.insertRelOTCDTO(drugName, name);
        }
    }

    void getRelOTCInDrug() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("药物", "OTC类型");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelOTCInDrug(key, it));
        }

    }

    /**
     * 关系：药物-不良反应
     **/
    void insertRelAdverseReactionsInDrug(String drugName, String name) {
        if (adverseReactionsRepository.isExits(name) > 0) {
            drugRelationRepository.insertRelAdverseReactionsDTA(drugName, name);
        } else if (diseaseRepository.isExits(name) > 0) {
            drugRelationRepository.insertRelAdverseReactionsDTD(drugName, name);
        } else if (symptomRepository.isExits(name) > 0) {
            drugRelationRepository.insertRelAdverseReactionsDTS(drugName, name);
        } else if (entityRepository.isExits(name) > 0) {
            drugRelationRepository.insertRelAdverseReactionsDTE(drugName, name);
        }
    }

    void getRelAdverseReactionsInDrug() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("药物", "不良反应");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelAdverseReactionsInDrug(key, it));
        }
    }


    /**
     * 关系：药物-适应症
     **/
    void insertRelIndicationsInDrug(String drugName, String name) {
        if (indicationsRepository.isExits(name) > 0) {
            drugRelationRepository.insertRelIndicationsDTI(drugName, name);
        } else if (diseaseRepository.isExits(name) > 0) {
            drugRelationRepository.insertRelIndicationsDTD(drugName, name);
        } else if (symptomRepository.isExits(name) > 0) {
            drugRelationRepository.insertRelIndicationsDTS(drugName, name);
        } else if (entityRepository.isExits(name) > 0) {
            drugRelationRepository.insertRelIndicationsDTE(drugName, name);
        }
    }

    void getRelIndicationsInDrug() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("药物", "适应症");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelIndicationsInDrug(key, it));
        }
    }

    /**
     * 关系：药物-分类
     **/
    void insertRelTypeInDrug(String drugName, String name) {
        if (typeRepository.isExits(name) > 0) {
            drugRelationRepository.insertRelTypeDTT(drugName, name);
        }
    }

    void getRelTypeInDrug() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("药物", "分类");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelTypeInDrug(key, it));
        }
    }

    /**
     * 关系：药物-注意事项
     **/
    void insertRelPrecautionsInDrug(String drugName, String name) {
        if (precautionsRepository.isExits(name) > 0) {
            drugRelationRepository.insertRelPrecautionsDTP(drugName, name);
        }
    }

    void getRelPrecautionsInDrug() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("药物", "注意事项");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelPrecautionsInDrug(key, it));
        }
    }

    /**
     * 关系：药物-禁忌证
     **/
    void insertRelContraindicationsInDrug(String drugName, String name) {
        if (contraindicationsRepository.isExits(name) > 0) {
            drugRelationRepository.insertRelContraindicationsDTC(drugName, name);
        } else if (diseaseRepository.isExits(name) > 0) {
            drugRelationRepository.insertRelContraindicationsDTD(drugName, name);
        } else if (symptomRepository.isExits(name) > 0) {
            drugRelationRepository.insertRelContraindicationsDTS(drugName, name);
        } else if (entityRepository.isExits(name) > 0) {
            drugRelationRepository.insertRelContraindicationsDTE(drugName, name);
        }
    }

    void getRelContraindicationsInDrug() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("药物", "禁忌证");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelContraindicationsInDrug(key, it));
        }
    }

    /**
     * 关系：药物-所属科目
     **/
    void insertRelSubjectInDrug(String drugName, String name) {
        if (subjectRepository.isExits(name) > 0) {
            drugRelationRepository.insertRelSubjectDTS(drugName, name);
        }
    }

    void getRelSubjectInDrug() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("药物", "所属科目");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelSubjectInDrug(key, it));
        }
    }

    /**
     * 关系：诊疗-相关疾病
     **/
    void insertRelRelatedDiseaseInTreatment(String treatmentName, String name) {
        if (relatedDiseaseRepository.isExits(name) > 0) {
            treatmentRelationRepository.insertRelRelatedDiseaseTTR(treatmentName, name);
        } else if (diseaseRepository.isExits(name) > 0) {
            treatmentRelationRepository.insertRelRelatedDiseaseTTD(treatmentName, name);
        }

    }

    void getRelRelatedDiseaseInTreatment() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("诊疗", "相关疾病");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelRelatedDiseaseInTreatment(key, it));
        }
    }

    /**
     * 关系：诊疗-相关症状
     **/
    void insertRelRelatedSymptomInTreatment(String treatmentName, String name) {
        if (relatedSymptomRepository.isExits(name) > 0) {
            treatmentRelationRepository.insertRelRelatedSymptomTTR(treatmentName, name);
        } else if (symptomRepository.isExits(name) > 0) {
            treatmentRelationRepository.insertRelRelatedDiseaseTTS(treatmentName, name);
        }

    }

    void getRelRelatedSymptomInTreatment() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("诊疗", "相关症状");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelRelatedSymptomInTreatment(key, it));
        }
    }

    /**
     * 关系：诊疗-检查科目
     **/
    void insertRelCheckSubjectInTreatment(String treatmentName, String name) {
        if (checkSubjectRepository.isExits(name) > 0) {
            treatmentRelationRepository.insertRelCheckSubjectTTCS(treatmentName, name);
        } else if (checkRepository.isExits(name) > 0) {
            treatmentRelationRepository.insertRelCheckSubjectTTC(treatmentName, name);
        } else if (auxiliaryExaminationRepository.isExits(name) > 0) {
            treatmentRelationRepository.insertRelCheckSubjectTTC(treatmentName, name);
        }

    }

    void getRelCheckSubjectInTreatment() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("诊疗", "检查科目");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelCheckSubjectInTreatment(key, it));
        }
    }

    //症状

    /**
     * 插入检查关系
     **/
    void insertRelCheckInSymptom(String symptomName, String name) {
        if (checkRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelCheckSTC(symptomName, name);
        } else if (auxiliaryExaminationRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelCheckSTA(symptomName, name);
        } else if (checkSubjectRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelCheckSTCS(symptomName, name);
        }
    }

    void getRelCheckInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "检查");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelCheckInSymptom(key, it));
        }
    }

    /**
     * 插入所属科室关系
     **/
    void insertRelDepartmentInSymptom(String symptomName, String name) {
        if (departmentRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelDepartment(symptomName, name);
        }
    }

    void getRelDepartmentInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "所属科室");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelDepartmentInSymptom(key, it));
        }
    }

    /**
     * 插入发病部位关系
     **/
    void insertRelDiseaseSiteInSymptom(String symptomName, String name) {
        if (diseaseRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelDiseaseSiteSTD(symptomName, name);
        } else if (symptomRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelDiseaseSiteSTS(symptomName, name);
        } else if (diseaseSiteRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelDiseaseSiteSTDS(symptomName, name);
        }
    }

    void getRelDiseaseSiteInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "发病部位");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelDiseaseSiteInSymptom(key, it));
        }
    }

    /**
     * 插入相关疾病关系
     **/
    void insertRelRelatedDiseaseInSymptom(String symptomName, String name) {
        if (diseaseRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelRelatedDiseaseSTD(symptomName, name);
        } else if (relatedDiseaseRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelRelatedDiseaseSTR(symptomName, name);
        }
    }

    void getRelRelatedDiseaseInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "相关疾病");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelRelatedDiseaseInSymptom(key, it));
        }
    }

    /**
     * 插入相关症状关系
     **/
    void insertRelRelatedSymptomInSymptom(String symptomName, String name) {
        if (symptomRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelRelatedSymptomSTS(symptomName, name);
        } else if (relatedSymptomRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelRelatedSymptomSTR(symptomName, name);
        }
    }

    void getRelRelatedSymptomInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "相关症状");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelRelatedSymptomInSymptom(key, it));
        }
    }

    /**
     * 插入病理分型关系
     **/
    void insertRelPathologicalTypeInSymptom(String symptomName, String name) {
        if (pathologicalTypeRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelPathologicalType(symptomName, name);
        }
    }

    void getRelPathologicalTypeInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "病理分型");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelPathologicalTypeInSymptom(key, it));
        }
    }

    /**
     * 插入辅助治疗关系
     **/
    void insertRelAdjuvantTherapyInSymptom(String symptomName, String name) {
        if (treatmentRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelAdjuvantTherapySTT(symptomName, name);
        } else if (adjuvantTherapyRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelAdjuvantTherapySTA(symptomName, name);
        }
    }

    void getRelAdjuvantTherapyInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "辅助治疗");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelAdjuvantTherapyInSymptom(key, it));
        }
    }

    /**
     * 插入传染性关系
     **/
    void insertRelInfectiousInSymptom(String symptomName, String name) {
        if (infectiousRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelInfectious(symptomName, name);
        }
    }

    void getRelInfectiousInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "传染性");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelInfectiousInSymptom(key, it));
        }
    }

    /**
     * 插入并发症关系
     **/
    void insertRelComplicationInSymptom(String symptomName, String name) {
        if (diseaseRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelComplicationSTD(symptomName, name);
        } else if (symptomRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelComplicationSTS(symptomName, name);
        } else if (entityRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelComplicationSTC(symptomName, name);
        }
    }

    void getRelComplicationInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "并发症");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelComplicationInSymptom(key, it));
        }
    }

    /**
     * 插入相关导致关系
     **/
    void insertRelRelatedToInSymptom(String symptomName, String name) {
        if (relatedToRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelRelatedTo(symptomName, name);
        }
    }

    void getRelRelatedToInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "相关导致");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelRelatedToInSymptom(key, it));
        }
    }

    /**
     * 插入临床症状及体征关系
     **/
    void insertRelSymptomAndSignInSymptom(String symptomName, String name) {
        if (diseaseRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelSymptomAndSignSTD(symptomName, name);
        } else if (symptomRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelSymptomAndSignSTS(symptomName, name);
        } else if (symptomAndSignRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelSymptomAndSignSTSAS(symptomName, name);
        }
    }

    void getRelSymptomAndSignInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "临床症状及体征");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelSymptomAndSignInSymptom(key, it));
        }
    }

    /**
     * 插入辅助检查关系
     **/
    void insertRelAuxiliaryExaminationInSymptom(String symptomName, String name) {
        if (checkRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelAuxiliaryExaminationSTC(symptomName, name);
        } else if (auxiliaryExaminationRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelAuxiliaryExaminationSTA(symptomName, name);
        } else if (checkSubjectRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelAuxiliaryExaminationSTCS(symptomName, name);
        }
    }

    void getRelAuxiliaryExaminationInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "辅助检查");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelAuxiliaryExaminationInSymptom(key, it));
        }
    }

    /**
     * 插入药物治疗关系
     **/
    void insertRelDrugTherapyInSymptom(String symptomName, String name) {
        if (drugRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelDrugTherapySTD(symptomName, name);
        } else if (drugTherapyRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelDrugTherapySTDT(symptomName, name);
        }
    }

    void getRelDrugTherapyInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "药物治疗");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelDrugTherapyInSymptom(key, it));
        }
    }

    /**
     * 插入阶段关系
     **/
    void insertRelStageInSymptom(String symptomName, String name) {
        if (stageRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelStage(symptomName, name);
        }
    }

    void getRelStageInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "阶段");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelStageInSymptom(key, it));
        }
    }

    /**
     * 插入多发群体关系
     **/
    void insertRelMultipleGroupsInSymptom(String symptomName, String name) {
        if (multipleGroupsRepository.isExits(name) > 0) {
            symptomRelationRepository.insertRelMultipleGroups(symptomName, name);
        }
    }

    void getRelMultipleGroupsInSymptom() {
        HashMap<String, List<String>> map = new CrawlerUtil().getDiseaseJsonComponentToHashMap("症状", "多发群体");
        for (String key : map.keySet()
        ) {
            map.get(key).forEach(it -> insertRelMultipleGroupsInSymptom(key, it));
        }
    }

    public void insertAllRelation() {
        //疾病
        getRelComplicationInDisease();
        getRelSymptomAndSignInDisease();
        getRelPrognosisInDisease();
        getRelDiseaseRateInDisease();
        getRelDrugTherapyInDisease();
        getRelAdjuvantTherapyInDisease();
        getRelOperationInDisease();
        getRelPathogenesisInDisease();
        getRelPathologicalTypeInDisease();
        getRelDiagnosisInDisease();
        getRelPathophysiologyInDisease();
        getRelDiseaseSiteInDisease();
        getRelDepartmentInDisease();
        getRelMultipleGroupsInDisease();
        getRelCauseInDisease();
        getRelPrognosticSurvivalTimeInDisease();
        getRelHighRiskFactorsInDisease();
        getRelRelatedDiseaseInDisease();
        getRelRelatedSymptomInDisease();
        getRelTreatmentProgramsInDisease();
        //症状
        getRelCheckInSymptom();
        getRelDepartmentInSymptom();
        getRelDiseaseSiteInSymptom();
        getRelRelatedDiseaseInSymptom();
        getRelRelatedSymptomInSymptom();
        getRelPathologicalTypeInSymptom();
        getRelAdjuvantTherapyInSymptom();
        getRelInfectiousInSymptom();
        getRelComplicationInSymptom();
        getRelRelatedToInSymptom();
        getRelSymptomAndSignInSymptom();
        getRelAuxiliaryExaminationInSymptom();
        getRelDrugTherapyInSymptom();
        getRelStageInSymptom();
        getRelMultipleGroupsInSymptom();
        getRelCauseInSymptom();
        getRelTreatmentProgramsInSymptom();
        getRelPreventionInSymptom();
        getRelSpreadWayInSymptom();

        //药物
        getRelIngredientsInDrug();
        getRelOTCInDrug();
        getRelAdverseReactionsInDrug();
        getRelIndicationsInDrug();
        getRelTypeInDrug();
        getRelPrecautionsInDrug();
        getRelContraindicationsInDrug();
        getRelSubjectInDrug();

        //诊疗
        getRelRelatedDiseaseInTreatment();
        getRelRelatedSymptomInTreatment();
        getRelCheckSubjectInTreatment();
    }


}
