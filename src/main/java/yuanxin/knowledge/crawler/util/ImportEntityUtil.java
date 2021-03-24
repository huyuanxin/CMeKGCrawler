package yuanxin.knowledge.crawler.util;

import org.springframework.stereotype.Component;
import yuanxin.knowledge.crawler.repository.*;

import javax.swing.*;
import java.util.List;

@Component
public class ImportEntityUtil {

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


    public ImportEntityUtil(DiseaseRepository diseaseRepository,
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
                            CheckSubjectRepository checkSubjectRepository) {
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

    void initSymptom() {
        try {
            symptomRepository.initSymptom();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initPathologicalType(){
        try {
            pathologicalTypeRepository.initPathologicalType();
        }catch (Exception e){
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initTreatment() {
        try {
            treatmentRepository.initTreatment();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initDiagnosis(){
        try {
            diagnosisRepository.initDiagnosis();
        }catch (Exception e){
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initPathophysiology(){
        try {
            pathophysiologyRepository.initPathophysiology();
        }catch (Exception e){
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initDiseaseSite(){
        try {
            diseaseSiteRepository.initDiseaseSite();
        }catch (Exception e){
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initDepartment(){
        try {
            departmentRepository.initDepartment();
        }catch (Exception e){
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initMultipleGroups(){
        try {
            multipleGroupsRepository.initMultipleGroups();
        }catch (Exception e){
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initCauseRepository(){
        try {
            causeRepository.initCause();
        }catch (Exception e){
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initPrognosticSurvivalTime(){
        try {
            prognosticSurvivalTimeRepository.initPrognosticSurvivalTime();
        }catch (Exception e){
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initHighRiskFactors(){
        try {
            highRiskFactorsRepository.initHighRiskFactors();
        }catch (Exception e){
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initPrognosis() {
        try {
            prognosisRepository.initPrognosis();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initAttribute() {
        try {
            attributeRepository.initAttribute();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initDiseaseRate() {
        try {
            diseaseRateRepository.initDiseaseRate();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initDrug(){
        try {
            drugRepository.initDrug();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initDrugTherapy(){
        try {
            drugTherapyRepository.initDrugTherapy();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initAdjuvantTherapy() {
        try {
            adjuvantTherapyRepository.initAdjuvantTherapy();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initOperation() {
        try {
            operationRepository.initOperation();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initPathogenesis() {
        try {
            pathogenesisRepository.initPathogenesis();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initSymptomAndSign() {
        try {
            symptomAndSignRepository.initSymptomAndSign();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }


    //症状
    void initCheckRepository(){
        try {
            checkRepository.initCheck();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initRelatedDisease(){
        try {
            relatedDiseaseRepository.initRelatedDisease();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initRelatedSymptom(){
        try {
            relatedSymptomRepository.initRelatedSymptom();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initInfectious(){
        try {
            infectiousRepository.initInfectious();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initRelatedTo(){
        try {
            relatedToRepository.initRelatedTo();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initAuxiliaryExamination(){
        try {
            auxiliaryExaminationRepository.initAuxiliaryExamination();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initStage(){
        try {
            stageRepository.initStage();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initTreatmentPrograms(){
        try {
            treatmentProgramsRepository.initTreatmentPrograms();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initPrevention(){
        try {
            preventionRepository.initPrevention();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initSpreadWay(){
        try {
            spreadWayRepository.initSpreadWay();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    //药物
    void initType(){
        try {
            typeRepository.initType();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initPrecautions(){
        try {
            precautionsRepository.initPrecautions();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initContraindications(){
        try {
            contraindicationsRepository.initContraindications();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initSubject(){
        try {
            subjectRepository.initSubject();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initIngredients(){
        try {
            ingredientsRepository.initIngredients();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initOTC(){
        try {
            OTCRepository.initOTC();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initAdverseReactions(){
        try {
            adverseReactionsRepository.initAdverseReactions();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    void initIndications(){
        try {
            indicationsRepository.initIndications();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }

    //诊疗
    void initCheckSubject(){
        try {
            checkSubjectRepository.initCheckSubject();
        } catch (Exception e) {
            System.out.println("初始化失败，可能是约束已经存在");
        }
    }


    public void init() {
        //疾病
        initDisease();
        initSymptom();
        initComplication();
        initPathologicalType();
        initTreatment();
        initDiagnosis();
        initPathophysiology();
        initDiseaseSite();
        initDepartment();
        initMultipleGroups();
        initCauseRepository();
        initPrognosticSurvivalTime();
        initHighRiskFactors();
        initPrognosis();
        initAttribute();
        initDiseaseRate();
        initDrug();
        initDrugTherapy();
        initAdjuvantTherapy();
        initOperation();
        initPathogenesis();
        initSymptomAndSign();

        //症状
        initCheckRepository();
        initRelatedDisease();
        initRelatedSymptom();
        initInfectious();
        initRelatedTo();
        initAuxiliaryExamination();
        initStage();
        initTreatmentPrograms();
        initPrevention();
        initSpreadWay();

        //药物
        initType();
        initPrecautions();
        initContraindications();
        initSubject();
        initIngredients();
        initOTC();
        initAdverseReactions();
        initIndications();

        //诊疗
        initCheckSubject();
    }

    //疾病
    public void insertAllDisease() {
        List<String> diseaseNameList = CrawlerUtil.getNameList("疾病");
        for (String disease : diseaseNameList
        ) {
            if (symptomRepository.isExits(disease) < 1) {
                try {
                    diseaseRepository.insertDisease(disease);
                    System.out.println("插入:" + disease + "进入neo4j的Disease");
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
            if (diseaseRepository.isExits(symptom) < 1) {
                try {
                    symptomRepository.insertSymptom(symptom);
                    System.out.println("插入:" + symptom + "进入neo4j的Symptom");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    void insertAllComplicationInDisease() {
        List<String> complicationNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "并发症");
        for (String complication : complicationNameList
        ) {
            if (diseaseRepository.isExits(complication) < 1) {
                System.out.println(diseaseRepository.isExits(complication));
                if (symptomRepository.isExits(complication) < 1) {
                    try {
                        entityRepository.insertComplication(complication);
                        System.out.println("插入:" + complication + "进入neo4j的Complication");
                    } catch (Exception e) {
                        System.out.println("插入失败");
                    }
                }
            }
        }
    }

    public void insertAllPathologicalTypeInDisease() {
        List<String> pathlogicalTypeNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "病理分型");
        for (String pathlogicalType : pathlogicalTypeNameList
        ){
            if (pathologicalTypeRepository.isExits(pathlogicalType) < 1) {
                try {
                    pathologicalTypeRepository.insertPathologicalType(pathlogicalType);
                    System.out.println("插入:" + pathlogicalType + "进入neo4j的PathologicalType");
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
                    System.out.println("插入:" + treatment + "进入neo4j的Treatment");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    void insertAllDiagnosis(){
        List<String> diagnosisNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "鉴别诊断");
        for (String diagnosis : diagnosisNameList
        ){
            if (treatmentRepository.isExits(diagnosis) < 1) {
                System.out.println(treatmentRepository.isExits(diagnosis));
                if (diagnosisRepository.isExits(diagnosis) < 1) {
                    try {
                        diagnosisRepository.insertDiagnosis(diagnosis);
                        System.out.println("插入:" + diagnosis + "进入neo4j的Diagnosis");
                    } catch (Exception e) {
                        System.out.println("插入失败");
                    }
                }
            }
        }
    }

    void insertAllPathophysiology(){
        List<String> pathophysiologyNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "病理生理");
        for (String pathophysiology : pathophysiologyNameList
        ){
            if (diseaseRepository.isExits(pathophysiology) < 1) {
                System.out.println(diseaseRepository.isExits(pathophysiology));
                if (symptomRepository.isExits(pathophysiology) < 1) {
                    try {
                        pathophysiologyRepository.insertPathophysiology(pathophysiology);
                        System.out.println("插入:" + pathophysiology + "进入neo4j的Pathophysiology");
                    } catch (Exception e) {
                        System.out.println("插入失败");
                    }
                }
            }
        }
    }

    void insertAllDiseaseSiteInDisease(){
        List<String> diseaseSiteNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "发病部位");
        for (String diseaseSite : diseaseSiteNameList
        ){
            if (diseaseRepository.isExits(diseaseSite) < 1) {
                System.out.println(diseaseRepository.isExits(diseaseSite));
                if (symptomRepository.isExits(diseaseSite) < 1) {
                    try {
                        diseaseSiteRepository.insertDiseaseSite(diseaseSite);
                        System.out.println("插入:" + diseaseSite + "进入neo4j的DiseaseSite");
                    } catch (Exception e) {
                        System.out.println("插入失败");
                    }
                }
            }
        }
    }

    public void insertAllDepartmentInDisease(){
        List<String> departmentNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "所属科室");
        for (String department : departmentNameList
        ) {
            if (departmentRepository.isExits(department) < 1) {
                try {
                    departmentRepository.insertDepartment(department);
                    System.out.println("插入:" + department + "进入neo4j的Department");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    public void insertAllMultipleGroupsInDisease(){
        List<String> multipleGroupsNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "多发群体");
        for (String multipleGroups : multipleGroupsNameList
        ){
            if (multipleGroupsRepository.isExits(multipleGroups) < 1) {
                try {
                    multipleGroupsRepository.insertMultipleGroups(multipleGroups);
                    System.out.println("插入:" + multipleGroups + "进入neo4j的MultipleGroups");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    void insertAllCause(){
        List<String> causeNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "病因");
        for (String cause : causeNameList
        ){
            if (diseaseRepository.isExits(cause) < 1) {
                System.out.println(diseaseRepository.isExits(cause));
                if (causeRepository.isExits(cause) < 1) {
                    try {
                        causeRepository.insertCause(cause);
                        System.out.println("插入:" + cause + "进入neo4j的Cause");
                    } catch (Exception e) {
                        System.out.println("插入失败");
                    }
                }
            }
        }
    }

    public void insertAllPrognosticSurvivalTimeRepository(){
        List<String> prognosticSurvivalTimeNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "预后生存时间");
        for (String prognosticSurvivalTime : prognosticSurvivalTimeNameList
        ){
            if (prognosticSurvivalTimeRepository.isExits(prognosticSurvivalTime) < 1) {
                try {
                    prognosticSurvivalTimeRepository.insertPrognosticSurvivalTime(prognosticSurvivalTime);
                    System.out.println("插入:" + prognosticSurvivalTime + "进入neo4j的PrognosticSurvivalTime");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    public void insertAllHighRiskFactorsRepository(){
        List<String> highRiskFactorsNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "高危因素");
        for (String highRiskFactors : highRiskFactorsNameList
        ){
            if (prognosticSurvivalTimeRepository.isExits(highRiskFactors) < 1) {
                try {
                    prognosticSurvivalTimeRepository.insertPrognosticSurvivalTime(highRiskFactors);
                    System.out.println("插入:" + highRiskFactors + "进入neo4j的PrognosticSurvivalTime");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    public void insertAllPrognosis() {
        List<String> prognosisNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "预后状况");
        for (String prognosis : prognosisNameList
        ) {
            if (prognosisRepository.isExits(prognosis) < 1) {
                try {
                    prognosisRepository.insertPrognosis(prognosis);
                    System.out.println("插入:" + prognosis + "进入neo4j");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    public void insertAllAttribute() {
        List<String> attributeNameList = CrawlerUtil.getNameList("属性");
        for (String attribute : attributeNameList
        ) {
            if (attributeRepository.isExits(attribute) < 1) {
                try {
                    attributeRepository.insertAttribute(attribute);
                    System.out.println("插入:" + attribute + "进入neo4j");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    public void insertAllDiseaseRate() {
        List<String> diseaseRateNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "发病率");
        for (String diseaseRate : diseaseRateNameList
        ) {
            if (attributeRepository.isExits(diseaseRate) < 1) {
                try {
                    diseaseRateRepository.insertDiseaseRate(diseaseRate);
                    System.out.println("插入:" + diseaseRate + "进入neo4j");
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

    public void insertAllDrugTherapy() {
        List<String> drugTherapyNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "药物治疗");
        for (String drugTherapy : drugTherapyNameList
        ) {
            if (drugRepository.isExits(drugTherapy) < 1) {
                try {
                    drugTherapyRepository.insertDrugTherapy(drugTherapy);
                    System.out.println("插入:" + drugTherapy + "进入neo4j");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    public void insertAllAdjuvantTherapyInDisease() {
        List<String> adjuvantTherapyNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "辅助治疗");
        for (String adjuvantTherapy : adjuvantTherapyNameList
        ) {
            if (treatmentRepository.isExits(adjuvantTherapy) < 1) {
                try {
                    adjuvantTherapyRepository.insertAdjuvantTherapy(adjuvantTherapy);
                    System.out.println("插入:" + adjuvantTherapy + "进入neo4j");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    public void insertAllOperation() {
        List<String> operationNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "手术治疗");
        for (String operation : operationNameList
        ) {
            if (treatmentRepository.isExits(operation) < 1) {
                try {
                    operationRepository.insertOperation(operation);
                    System.out.println("插入:" + operation + "进入neo4j");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    public void insertAllPathogenesis() {
        List<String> pathogenesisNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "手术治疗");
        for (String pathogenesis : pathogenesisNameList
        ) {
            if (pathogenesisRepository.isExits(pathogenesis) < 1) {
                try {
                    pathogenesisRepository.insertPathogenesis(pathogenesis);
                    System.out.println("插入:" + pathogenesis + "进入neo4j");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    public void insertAllSymptomAndSignInDisease() {
        List<String> symptomAndSignNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "临床症状及体征");
        for (String symptomAndSign : symptomAndSignNameList
        ) {
            if (diseaseRepository.isExits(symptomAndSign) < 1) {
                System.out.println(diseaseRepository.isExits(symptomAndSign));
                if (symptomRepository.isExits(symptomAndSign) < 1) {
                    try {
                        symptomAndSignRepository.insertSymptomAndSign(symptomAndSign);
                        System.out.println("插入:" + symptomAndSign + "进入neo4j的Complication");
                    } catch (Exception e) {
                        System.out.println("插入失败");
                    }
                }
            }
        }
    }

    void insertAllTreatmentProgramsInDisease(){
        List<String> treatmentProgramsNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "治疗方案");
        for (String treatmentPrograms : treatmentProgramsNameList
        ){
            if (adjuvantTherapyRepository.isExits(treatmentPrograms) < 1) {
                if (drugTherapyRepository.isExits(treatmentPrograms) < 1) {
                    if (drugRepository.isExits(treatmentPrograms) < 1) {
                        if (treatmentRepository.isExits(treatmentPrograms) < 1) {
                            if (checkRepository.isExits(treatmentPrograms) < 1) {
                                if (auxiliaryExaminationRepository.isExits(treatmentPrograms) < 1) {
                                    if (operationRepository.isExits(treatmentPrograms) < 1) {
                                        if (treatmentProgramsRepository.isExits(treatmentPrograms) < 1) {
                                            try {
                                                treatmentProgramsRepository.insertTreatmentPrograms(treatmentPrograms);
                                                System.out.println("插入:" + treatmentPrograms + "进入neo4j的Cause");
                                            } catch (Exception e) {
                                                System.out.println("插入失败");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    void insertRelatedDiseaseInDisease(){
        List<String> relatedDiseaseNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "相关疾病");
        for (String relatedDisease : relatedDiseaseNameList
        ) {
            if (diseaseRepository.isExits(relatedDisease) < 1) {
                if (relatedDiseaseRepository.isExits(relatedDisease) < 1) {
                    try {
                        relatedDiseaseRepository.insertRelatedDisease(relatedDisease);
                        System.out.println("插入:" + relatedDisease + "进入neo4j的RelatedDisease");
                    } catch (Exception e) {
                        System.out.println("插入失败");
                    }
                }
            }
        }
    }

    void insertRelatedSymptomInDisease(){
        List<String> relatedSymptomNameList = CrawlerUtil.getDiseaseJsonComponent("疾病", "相关疾病");
        for (String relatedSymptom : relatedSymptomNameList
        ) {
            if (symptomRepository.isExits(relatedSymptom) < 1) {
                if (relatedSymptomRepository.isExits(relatedSymptom) < 1) {
                    try {
                        relatedSymptomRepository.insertRelatedSymptom(relatedSymptom);
                        System.out.println("插入:" + relatedSymptom + "进入neo4j的RelatedSymptom");
                    } catch (Exception e) {
                        System.out.println("插入失败");
                    }
                }
            }
        }
    }


    //症状
    public void insertAllCheck(){
        List<String> checkNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "检查");
        for (String check : checkNameList
        ) {
            if (checkRepository.isExits(check) < 1) {
                try {
                    checkRepository.insertCheck(check);
                    System.out.println("插入:" + check + "进入neo4j的Check");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    public void insertAllDepartmentInSymptom(){
        List<String> departmentNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "所属科室");
        for (String department : departmentNameList
        ) {
            if (departmentRepository.isExits(department) < 1) {
                try {
                    departmentRepository.insertDepartment(department);
                    System.out.println("插入:" + department + "进入neo4j的Department");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    void insertAllDiseaseSiteInSymptom(){
        List<String> diseaseSiteNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "发病部位");
        for (String diseaseSite : diseaseSiteNameList
        ){
            if (diseaseSiteRepository.isExits(diseaseSite) < 1) {
                if (diseaseRepository.isExits(diseaseSite) < 1) {
                    System.out.println(diseaseRepository.isExits(diseaseSite));
                    if (symptomRepository.isExits(diseaseSite) < 1) {
                        try {
                            diseaseSiteRepository.insertDiseaseSite(diseaseSite);
                            System.out.println("插入:" + diseaseSite + "进入neo4j的DiseaseSite");
                        } catch (Exception e) {
                            System.out.println("插入失败");
                        }
                    }
                }
            }
        }
    }

    void insertRelatedDiseaseInSymptom(){
        List<String> relatedDiseaseNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "相关疾病");
        for (String relatedDisease : relatedDiseaseNameList
        ) {
            if (diseaseRepository.isExits(relatedDisease) < 1) {
                if (relatedDiseaseRepository.isExits(relatedDisease) < 1) {
                    try {
                        relatedDiseaseRepository.insertRelatedDisease(relatedDisease);
                        System.out.println("插入:" + relatedDisease + "进入neo4j的RelatedDisease");
                    } catch (Exception e) {
                        System.out.println("插入失败");
                    }
                }
            }
        }
    }

    void insertRelatedSymptomInSymptom(){
        List<String> relatedSymptomNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "相关疾病");
        for (String relatedSymptom : relatedSymptomNameList
        ) {
            if (symptomRepository.isExits(relatedSymptom) < 1) {
                if (relatedSymptomRepository.isExits(relatedSymptom) < 1) {
                    try {
                        relatedSymptomRepository.insertRelatedSymptom(relatedSymptom);
                        System.out.println("插入:" + relatedSymptom + "进入neo4j的RelatedSymptom");
                    } catch (Exception e) {
                        System.out.println("插入失败");
                    }
                }
            }
        }
    }

    public void insertAllPathologicalTypeInSymptom() {
        List<String> pathlogicalTypeNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "病理分型");
        for (String pathlogicalType : pathlogicalTypeNameList
        ){
            if (pathologicalTypeRepository.isExits(pathlogicalType) < 1) {
                try {
                    pathologicalTypeRepository.insertPathologicalType(pathlogicalType);
                    System.out.println("插入:" + pathlogicalType + "进入neo4j的PathologicalType");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    public void insertAllAdjuvantTherapyInSymptom() {
        List<String> adjuvantTherapyNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "辅助治疗");
        for (String adjuvantTherapy : adjuvantTherapyNameList
        ) {
            if (adjuvantTherapyRepository.isExits(adjuvantTherapy)< 1) {
                if (treatmentRepository.isExits(adjuvantTherapy) < 1) {
                    try {
                        adjuvantTherapyRepository.insertAdjuvantTherapy(adjuvantTherapy);
                        System.out.println("插入:" + adjuvantTherapy + "进入neo4j");
                    } catch (Exception e) {
                        System.out.println("插入失败");
                    }
                }
            }
        }
    }

    public void insertAllInfectious(){
        List<String> infectiousNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "传染性");
        for (String infectious : infectiousNameList
        ) {
            if (infectiousRepository.isExits(infectious) < 1) {
                try {
                    infectiousRepository.insertInfectious(infectious);
                    System.out.println("插入:" + infectious + "进入neo4j的Infectious");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    void insertAllComplicationInSymptom() {
        List<String> complicationNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "并发症");
        for (String complication : complicationNameList
        ) {
            if (entityRepository.isExits(complication) < 1) {
                if (diseaseRepository.isExits(complication) < 1) {
                    System.out.println(diseaseRepository.isExits(complication));
                    if (symptomRepository.isExits(complication) < 1) {
                        try {
                            entityRepository.insertComplication(complication);
                            System.out.println("插入:" + complication + "进入neo4j的Complication");
                        } catch (Exception e) {
                            System.out.println("插入失败");
                        }
                    }
                }
            }
        }
    }

    public void insertAllRelatedTo(){
        List<String> relatedToNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "相关导致");
        for (String relatedTo : relatedToNameList
        ) {
            if (relatedToRepository.isExits(relatedTo) < 1) {
                try {
                    relatedToRepository.insertRelatedTo(relatedTo);
                    System.out.println("插入:" + relatedTo  + "进入neo4j的RelatedTo");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    public void insertAllSymptomAndSignInSymptom() {
        List<String> symptomAndSignNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "临床症状及体征");
        for (String symptomAndSign : symptomAndSignNameList
        ) {
            if (diseaseRepository.isExits(symptomAndSign) < 1) {
                System.out.println(diseaseRepository.isExits(symptomAndSign));
                if (symptomRepository.isExits(symptomAndSign) < 1) {
                    if (symptomAndSignRepository.isExits(symptomAndSign) < 1) {
                        try {
                            symptomAndSignRepository.insertSymptomAndSign(symptomAndSign);
                            System.out.println("插入:" + symptomAndSign + "进入neo4j的Complication");
                        } catch (Exception e) {
                            System.out.println("插入失败");
                        }
                    }
                }
            }
        }
    }

    public void insertAllAuxiliaryExamination() {
        List<String> auxiliaryExaminationNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "辅助检查");
        for (String auxiliaryExamination : auxiliaryExaminationNameList
        ) {
            if (checkRepository.isExits(auxiliaryExamination) < 1) {
                if (auxiliaryExaminationRepository.isExits(auxiliaryExamination) < 1) {
                    try {
                        auxiliaryExaminationRepository.insertAuxiliaryExamination(auxiliaryExamination);
                        System.out.println("插入:" + auxiliaryExamination + "进入neo4j的Complication");
                    } catch (Exception e) {
                        System.out.println("插入失败");
                    }
                }
            }
        }
    }

    public void insertAllDrugTherapyInSymptom() {
        List<String> drugTherapyNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "药物治疗");
        for (String drugTherapy : drugTherapyNameList
        ) {
            if (drugRepository.isExits(drugTherapy) < 1) {
                if (drugTherapyRepository.isExits(drugTherapy) < 1) {
                    try {
                        drugTherapyRepository.insertDrugTherapy(drugTherapy);
                        System.out.println("插入:" + drugTherapy + "进入neo4j");
                    } catch (Exception e) {
                        System.out.println("插入失败");
                    }
                }
            }
        }
    }

    public void insertAllStage() {
        List<String> stageNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "阶段");
        for (String stage : stageNameList
        ) {
            if (stageRepository.isExits(stage) < 1) {
                try {
                    stageRepository.insertStage(stage);
                    System.out.println("插入:" + stage + "进入neo4j");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    public void insertAllMultipleGroupsInSymptom(){
        List<String> multipleGroupsNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "多发群体");
        for (String multipleGroups : multipleGroupsNameList
        ){
            if (multipleGroupsRepository.isExits(multipleGroups) < 1) {
                try {
                    multipleGroupsRepository.insertMultipleGroups(multipleGroups);
                    System.out.println("插入:" + multipleGroups + "进入neo4j的MultipleGroups");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    void insertAllCauseInSymptom(){
        List<String> causeNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "病因");
        for (String cause : causeNameList
        ){
            if (diseaseRepository.isExits(cause) < 1) {
                System.out.println(diseaseRepository.isExits(cause));
                if (causeRepository.isExits(cause) < 1) {
                    try {
                        causeRepository.insertCause(cause);
                        System.out.println("插入:" + cause + "进入neo4j的Cause");
                    } catch (Exception e) {
                        System.out.println("插入失败");
                    }
                }
            }
        }
    }

    void insertAllTreatmentProgramsInSymptom(){
        List<String> treatmentProgramsNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "治疗方案");
        for (String treatmentPrograms : treatmentProgramsNameList
        ){
            if (adjuvantTherapyRepository.isExits(treatmentPrograms) < 1) {
                if (drugTherapyRepository.isExits(treatmentPrograms) < 1) {
                    if (drugRepository.isExits(treatmentPrograms) < 1) {
                        if (treatmentRepository.isExits(treatmentPrograms) < 1) {
                            if (checkRepository.isExits(treatmentPrograms) < 1) {
                                if (auxiliaryExaminationRepository.isExits(treatmentPrograms) < 1) {
                                    if (treatmentProgramsRepository.isExits(treatmentPrograms) < 1) {
                                        try {
                                            treatmentProgramsRepository.insertTreatmentPrograms(treatmentPrograms);
                                            System.out.println("插入:" + treatmentPrograms + "进入neo4j的Cause");
                                        } catch (Exception e) {
                                            System.out.println("插入失败");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    void insertAllPrevention(){
        List<String> preventionNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "预防");
        for (String prevention : preventionNameList
        ){
            if (preventionRepository.isExits(prevention) < 1) {
                try {
                    preventionRepository.insertPrevention(prevention);
                    System.out.println("插入:" + prevention + "进入neo4j的Cause");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    void insertAllSpreadWay(){
        List<String> spreadWayNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "传播途径");
        for (String spreadWay : spreadWayNameList
        ){
            if (spreadWayRepository.isExits(spreadWay) < 1) {
                try {
                    spreadWayRepository.insertSpreadWay(spreadWay);
                    System.out.println("插入:" + spreadWay + "进入neo4j的Cause");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }


    //药物
    public void insertAllType(){
        List<String> typeNameList = CrawlerUtil.getDiseaseJsonComponent("药物", "分类");
        for (String type: typeNameList
        ) {
            if (typeRepository.isExits(type) < 1) {
                try {
                    typeRepository.insertType(type);
                    System.out.println("插入:" + type + "进入neo4j的Check");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    public void inserAllPrecautions(){
        List<String> precautionsNameList = CrawlerUtil.getDiseaseJsonComponent("药物", "注意事项");
        for (String precautions : precautionsNameList
        ) {
            if (precautionsRepository.isExits(precautions) < 1) {
                try {
                    precautionsRepository.insertPrecautions(precautions);
                    System.out.println("插入:" + precautions + "进入neo4j的Check");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    void insertAllContraindications(){
        List<String> contraindicationsNameList = CrawlerUtil.getDiseaseJsonComponent("症状", "禁忌证");
        for (String contraindications : contraindicationsNameList
        ) {
            if (diseaseRepository.isExits(contraindications) < 1) {
                if (symptomRepository.isExits(contraindications) < 1) {
                    if (entityRepository.isExits(contraindications) < 1) {
                        try {
                            contraindicationsRepository.insertContraindications(contraindications);
                            System.out.println("插入:" + contraindications + "进入neo4j的Department");
                        } catch (Exception e) {
                            System.out.println("插入失败");
                        }
                    }
                }
            }
        }
    }

    public void insertAllSublect(){
        List<String> subjectNameList = CrawlerUtil.getDiseaseJsonComponent("药物", "所属科目");
        for (String precautions : subjectNameList
        ) {
            if (subjectRepository.isExits(precautions) < 1) {
                try {
                    subjectRepository.insertSubject(precautions);
                    System.out.println("插入:" + precautions + "进入neo4j的Check");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    void insertAllIngredients(){
        List<String> ingredientsNameList = CrawlerUtil.getDiseaseJsonComponent("药物", "成份");
        for (String ingredients : ingredientsNameList
        ){
            if (ingredientsRepository.isExits(ingredients) < 1) {
                try {
                    ingredientsRepository.insertIngredients(ingredients);
                    System.out.println("插入:" + ingredients + "进入neo4j的Cause");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    void insertAllOTC(){
        List<String> OTCNameList = CrawlerUtil.getDiseaseJsonComponent("药物", "OTC类型");
        for (String OTC : OTCNameList
        ){
            if (OTCRepository.isExits(OTC) < 1) {
                try {
                    OTCRepository.insertOTC(OTC);
                    System.out.println("插入:" + OTC + "进入neo4j的Cause");
                } catch (Exception e) {
                    System.out.println("插入失败");
                }
            }
        }
    }

    void insertAllAdverseReactions(){
        List<String> adverseReactionsNameList = CrawlerUtil.getDiseaseJsonComponent("药物", "不良反应");
        for (String adverseReactions : adverseReactionsNameList
        ){
            if (diseaseRepository.isExits(adverseReactions) < 1) {
                if (symptomRepository.isExits(adverseReactions) < 1) {
                    if (entityRepository.isExits(adverseReactions) < 1) {
                        try {
                            adverseReactionsRepository.insertAdverseReactions(adverseReactions);
                            System.out.println("插入:" + adverseReactions + "进入neo4j的Cause");
                        } catch (Exception e) {
                            System.out.println("插入失败");
                        }
                    }
                }
            }
        }
    }

    void insertAllIndications(){
        List<String> indicationsNameList = CrawlerUtil.getDiseaseJsonComponent("药物", "适应症");
        for (String indications : indicationsNameList
        ){
            if (diseaseRepository.isExits(indications) < 1) {
                if (symptomRepository.isExits(indications) < 1) {
                    if (entityRepository.isExits(indications) < 1) {
                        try {
                            indicationsRepository.insertIndications(indications);
                            System.out.println("插入:" + indications + "进入neo4j的Cause");
                        } catch (Exception e) {
                            System.out.println("插入失败");
                        }
                    }
                }
            }
        }
    }

    //诊疗
    void insertRelatedDiseaseInTreatment(){
        List<String> relatedDiseaseNameList = CrawlerUtil.getDiseaseJsonComponent("诊疗", "相关疾病");
        for (String relatedDisease : relatedDiseaseNameList
        ) {
            if (diseaseRepository.isExits(relatedDisease) < 1) {
                if (relatedDiseaseRepository.isExits(relatedDisease) < 1) {
                    try {
                        relatedDiseaseRepository.insertRelatedDisease(relatedDisease);
                        System.out.println("插入:" + relatedDisease + "进入neo4j的RelatedDisease");
                    } catch (Exception e) {
                        System.out.println("插入失败");
                    }
                }
            }
        }
    }

    void insertRelatedSymptomInTreatment(){
        List<String> relatedSymptomNameList = CrawlerUtil.getDiseaseJsonComponent("诊疗", "相关疾病");
        for (String relatedSymptom : relatedSymptomNameList
        ) {
            if (symptomRepository.isExits(relatedSymptom) < 1) {
                if (relatedSymptomRepository.isExits(relatedSymptom) < 1) {
                    try {
                        relatedSymptomRepository.insertRelatedSymptom(relatedSymptom);
                        System.out.println("插入:" + relatedSymptom + "进入neo4j的RelatedSymptom");
                    } catch (Exception e) {
                        System.out.println("插入失败");
                    }
                }
            }
        }
    }

    void insertCheckSubject(){
        List<String> checkSubjectNameList = CrawlerUtil.getDiseaseJsonComponent("诊疗", "相关疾病");
        for (String checkSubject : checkSubjectNameList
        ) {
            if (checkRepository.isExits(checkSubject) < 1) {
                if (auxiliaryExaminationRepository.isExits(checkSubject) < 1) {
                    try {
                        checkSubjectRepository.insertCheckSubject(checkSubject);
                        System.out.println("插入:" + checkSubject + "进入neo4j的CheckSubject");
                    } catch (Exception e) {
                        System.out.println("插入失败");
                    }
                }
            }
        }
    }

    public void insertAll() {
        //疾病
        insertAllDisease();
        insertAllSymptom();
        insertAllComplicationInDisease();
        insertAllTreatment();
        insertAllPathologicalTypeInDisease();
        insertAllDiagnosis();
        insertAllPathophysiology();
        insertAllDiseaseSiteInDisease();
        insertAllDepartmentInDisease();
        insertAllMultipleGroupsInDisease();
        insertAllCause();
        insertAllPrognosticSurvivalTimeRepository();
        insertAllHighRiskFactorsRepository();
        insertAllPrognosis();
        insertAllAttribute();
        insertAllDiseaseRate();
        insertAllDrug();
        insertAllDrugTherapy();
        insertAllAdjuvantTherapyInDisease();
        insertAllOperation();
        insertAllPathogenesis();
        insertAllSymptomAndSignInDisease();
        insertAllTreatmentProgramsInDisease();
        insertRelatedDiseaseInDisease();
        insertRelatedSymptomInDisease();

        //症状
        insertAllCheck();
        insertAllDepartmentInSymptom();
        insertAllDiseaseSiteInSymptom();
        insertRelatedDiseaseInSymptom();
        insertRelatedSymptomInSymptom();
        insertAllPathologicalTypeInSymptom();
        insertAllAdjuvantTherapyInSymptom();
        insertAllInfectious();
        insertAllComplicationInSymptom();
        insertAllRelatedTo();
        insertAllSymptomAndSignInSymptom();
        insertAllAuxiliaryExamination();
        insertAllDrugTherapyInSymptom();
        insertAllStage();
        insertAllMultipleGroupsInSymptom();
        insertAllCauseInSymptom();
        insertAllTreatmentProgramsInSymptom();
        insertAllPrevention();
        insertAllSpreadWay();

        //药物
        insertAllType();
        inserAllPrecautions();
        insertAllContraindications();
        insertAllSublect();
        insertAllIngredients();
        insertAllOTC();
        insertAllAdverseReactions();
        insertAllIndications();

        //诊疗
        insertRelatedDiseaseInTreatment();
        insertRelatedSymptomInTreatment();
        insertCheckSubject();
    }

}
