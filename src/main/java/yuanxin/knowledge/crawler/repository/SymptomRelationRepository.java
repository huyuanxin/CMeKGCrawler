package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface SymptomRelationRepository extends Neo4jRepository<Object, Integer> {
    /**
     * 插入病因关系
     *
     * @param symptomName 症状名
     * @param diseaseName 疾病名
     */
    @Query("Match(s:Symptom),(d:Disease) where s.name=$symptomName AND d.name=$diseaseName Create (s)-[:cause]->(d)")
    void insertRelCauseSTD(@Param("symptomName") String symptomName, @Param("diseaseName") String diseaseName);

    /**
     * 插入病因关系
     *
     * @param symptomName 症状名
     * @param causeName   病因名
     */
    @Query("Match(s:Symptom),(c:Cause) where s.name=$symptomName AND c.name=$causeName Create (s)-[:cause]->(c)")
    void insertRelCauseSTC(@Param("symptomName") String symptomName, @Param("causeName") String causeName);

    /**
     * 插入治疗方案关系
     *
     * @param symptomName         症状名
     * @param adjuvantTherapyName 辅助治疗名
     */
    @Query("Match(s:Symptom),(a: AdjuvantTherapy) where s.name=$symptomName AND a.name=$adjuvantTherapyName Create (s)-[:treatmentPrograms]->(a)")
    void insertRelTreatmentProgramsSTA(@Param("symptomName") String symptomName, @Param("adjuvantTherapyName") String adjuvantTherapyName);

    /**
     * 插入治疗方案关系
     *
     * @param symptomName     症状名
     * @param drugTherapyName 药物治疗名
     */
    @Query("Match(s:Symptom),(u: DrugTherapy) where s.name=$symptomName AND u.name=$drugTherapyName Create (s)-[:treatmentPrograms]->(u)")
    void insertRelTreatmentProgramsSTU(@Param("symptomName") String symptomName, @Param("drugTherapyName") String drugTherapyName);

    /**
     * 插入治疗方案关系
     *
     * @param symptomName   症状名
     * @param operationName 手术治疗名
     */
    @Query("Match(s:Symptom),(o:Operation) where s.name=$symptomName AND o.name=$operationName Create (s)-[:treatmentPrograms]->(o)")
    void insertRelTreatmentProgramsSTO(@Param("symptomName") String symptomName, @Param("operationName") String operationName);

    /**
     * 插入治疗方案关系
     *
     * @param symptomName 症状名
     * @param drugName    药名
     */
    @Query("Match(s:Symptom),(db: Drug) where s.name=$symptomName AND db.name=$drugName Create (s)-[:treatmentPrograms]->(db)")
    void insertRelTreatmentProgramsSTD(@Param("symptomName") String symptomName, @Param("drugName") String drugName);

    /**
     * 插入治疗方案关系
     *
     * @param symptomName   症状名
     * @param treatmentName 诊疗名
     */
    @Query("Match(s:Symptom),(t:Treatment) where s.name=$symptomName AND t.name=$treatmentName Create (s)-[:treatmentPrograms]->(t)")
    void insertRelTreatmentProgramsSTT(@Param("symptomName") String symptomName, @Param("treatmentName") String treatmentName);

    /**
     * 插入治疗方案关系
     *
     * @param symptomName 症状名
     * @param checkName   检查名
     */
    @Query("Match(s:Symptom),(c:Check) where s.name=$symptomName AND c.name=$checkName Create (s)-[:treatmentPrograms]->(c)")
    void insertRelTreatmentProgramsSTC(@Param("symptomName") String symptomName, @Param("checkName") String checkName);

    /**
     * 插入治疗方案关系
     *
     * @param symptomName              症状名
     * @param auxiliaryExaminationName 辅助检查名
     */
    @Query("Match(s:Symptom),(a:AuxiliaryExamination) where s.name=$symptomName AND a.name=$auxiliaryExaminationName Create (s)-[:treatmentPrograms]->(a)")
    void insertRelTreatmentProgramsSTE(@Param("symptomName") String symptomName, @Param("auxiliaryExaminationName") String auxiliaryExaminationName);

    /**
     * 插入治疗方案关系
     *
     * @param symptomName           症状名
     * @param treatmentProgramsName 治疗方案名
     */
    @Query("Match(s:Symptom),(tp:TreatmentPrograms) where s.name=$symptomName AND tp.name=$treatmentProgramsName Create (s)-[:treatmentPrograms]->(tp)")
    void insertRelTreatmentProgramsSTTP(@Param("symptomName") String symptomName, @Param("treatmentProgramsName") String treatmentProgramsName);

    /**
     * 插入预防关系
     *
     * @param symptomName    症状名
     * @param preventionName 预防名
     */
    @Query("Match(s:Symptom),(p:Prevention) where s.name=$symptomName AND p.name=$preventionName Create (s)-[:prevention]->(p)")
    void insertRelPreventionSTP(@Param("symptomName") String symptomName, @Param("preventionName") String preventionName);

    /**
     * 插入传播途径关系
     *
     * @param symptomName   症状名
     * @param spreadWayName 传播途径名
     */
    @Query("Match(s:Symptom),(sw:SpreadWay) where s.name=$symptomName AND sw.name=$spreadWayName Create (s)-[:spreadWay]->(sw)")
    void insertRelSpreadWaySTSW(@Param("symptomName") String symptomName, @Param("spreadWayName") String spreadWayName);

    /**
     * 插入检查关系
     *
     * @param symptomName 症状名
     * @param checkName   检查名
     */
    @Query("Match(s:Symptom),(c:Check) where s.name=$symptomName AND c.name=$checkName Create (s)-[:check]->(c)")
    void insertRelCheckSTC(@Param("symptomName") String symptomName, @Param("checkName") String checkName);

    /**
     * 插入检查关系
     *
     * @param symptomName              症状名
     * @param auxiliaryExaminationName 辅助检查名
     */
    @Query("Match(s:Symptom),(a:AuxiliaryExamination) where s.name=$symptomName AND a.name=$auxiliaryExaminationName Create (s)-[:check]->(a)")
    void insertRelCheckSTA(@Param("symptomName") String symptomName, @Param("auxiliaryExaminationName") String auxiliaryExaminationName);

    /**
     * 插入检查关系
     *
     * @param symptomName      症状名
     * @param checkSubjectName 检查科目名
     */
    @Query("Match(s:Symptom),(cs:CheckSubject) where s.name=$symptomName AND cs.name=$checkSubjectName Create (s)-[:check]->(cs)")
    void insertRelCheckSTCS(@Param("symptomName") String symptomName, @Param("checkSubjectName") String checkSubjectName);

    /**
     * 插入所属科室关系
     *
     * @param symptomName    症状名
     * @param departmentName 所属科室名
     */
    @Query("Match(s:Symptom),(d:Department) where s.name=$symptomName AND d.name=$departmentName Create (s)-[:department]->(d)")
    void insertRelDepartment(@Param("symptomName") String symptomName, @Param("departmentName") String departmentName);

    /**
     * 插入发病部位关系
     *
     * @param symptomName     症状名
     * @param diseaseSiteName 发病部位名
     */
    @Query("Match(s:Symptom),(d:DiseaseSite) where s.name=$symptomName AND d.name=$diseaseSiteName Create (s)-[:diseaseSite]->(d)")
    void insertRelDiseaseSiteSTDS(@Param("symptomName") String symptomName, @Param("diseaseSiteName") String diseaseSiteName);

    /**
     * 插入发病部位关系
     *
     * @param symptomName 症状名
     * @param diseaseName 疾病名
     */
    @Query("Match(s:Symptom),(d:Disease) where s.name=$symptomName AND d.name=$diseaseName Create (s)-[:diseaseSite]->(d)")
    void insertRelDiseaseSiteSTD(@Param("symptomName") String symptomName, @Param("diseaseName") String diseaseName);

    /**
     * 插入发病部位关系
     *
     * @param symptomNameA 症状名
     * @param symptomNameB 症状名
     */
    @Query("Match(sa:Symptom),(sb:Symptom) where sa.name=$symptomNameA AND sb.name=$symptomNameB Create (sa)-[:diseaseSite]->(sb)")
    void insertRelDiseaseSiteSTS(@Param("symptomNameA") String symptomNameA, @Param("symptomNameB") String symptomNameB);

    /**
     * 插入相关疾病关系
     *
     * @param symptomName        症状名
     * @param relatedDiseaseName 相关疾病名
     */
    @Query("Match(sa:Symptom),(r:RelatedDisease) where sa.name=$symptomName AND r.name=$relatedDiseaseName Create (s)-[:relatedDisease]->(r)")
    void insertRelRelatedDiseaseSTR(@Param("symptomName") String symptomName, @Param("relatedDiseaseName") String relatedDiseaseName);

    /**
     * 插入相关疾病关系
     *
     * @param symptomName 症状名
     * @param diseaseName 疾病名
     */
    @Query("Match(s:Symptom),(d:Disease) where s.name=$symptomName AND d.name=$diseaseName Create (s)-[:relatedDisease]->(d)")
    void insertRelRelatedDiseaseSTD(@Param("symptomName") String symptomName, @Param("diseaseName") String diseaseName);

    /**
     * 插入相关症状关系
     *
     * @param symptomNameA 症状名
     * @param symptomNameB 症状名
     */
    @Query("Match(sa:Symptom),(sb:Symptom) where sa.name=$symptomNameA AND sb.name=$symptomNameB Create (sa)-[:relatedSymptom]->(sb)")
    void insertRelRelatedSymptomSTS(@Param("symptomNameA") String symptomNameA, @Param("symptomNameB") String symptomNameB);

    /**
     * 插入相关疾病关系
     *
     * @param symptomName        症状名
     * @param relatedSymptomName 相关疾病名
     */
    @Query("Match(s:Symptom),(r:RelatedSymptom) where s.name=$symptomName AND r.name=$relatedSymptomName Create (s)-[:relatedSymptom]->(r)")
    void insertRelRelatedSymptomSTR(@Param("symptomName") String symptomName, @Param("relatedSymptomName") String relatedSymptomName);

    /**
     * 插入病理分型关系
     *
     * @param symptomName          症状名
     * @param pathologicalTypeName 病理分型名
     */
    @Query("Match(s:Symptom),(p:PathologicalType) where s.name=$symptomName AND p.name=$pathologicalTypeName Create (s)-[:pathologicalType]->(p)")
    void insertRelPathologicalType(@Param("symptomName") String symptomName, @Param("pathologicalTypeName") String pathologicalTypeName);

    /**
     * 插入辅助治疗关系
     *
     * @param symptomName         症状名
     * @param adjuvantTherapyName 辅助治疗名
     */
    @Query("Match(s:Symptom),(a:AdjuvantTherapy) where s.name=$symptomName AND a.name=$adjuvantTherapyName Create (s)-[:adjuvantTherapy]->(a)")
    void insertRelAdjuvantTherapySTA(@Param("symptomName") String symptomName, @Param("adjuvantTherapyName") String adjuvantTherapyName);

    /**
     * 插入辅助治疗关系
     *
     * @param symptomName   症状名
     * @param treatmentName 诊疗名
     */
    @Query("Match(s:Symptom),(t:Treatment) where s.name=$symptomName AND t.name=$treatmentName Create (s)-[:adjuvantTherapy]->(t)")
    void insertRelAdjuvantTherapySTT(@Param("symptomName") String symptomName, @Param("treatmentName") String treatmentName);

    /**
     * 插入传染性关系
     *
     * @param symptomName    症状名
     * @param infectiousName 诊疗名
     */
    @Query("Match(s:Symptom),(i:Infectiou) where s.name=$symptomName AND i.name=$infectiousName Create (s)-[:infectious]->(i)")
    void insertRelInfectious(@Param("symptomName") String symptomName, @Param("infectiousName") String infectiousName);

    /**
     * 插入并发症关系
     *
     * @param symptomAName 症状名A
     * @param symptomBName 症状名B
     */
    @Query("Match(s:Symptom),(db:Symptom) where s.name=$symptomAName AND db.name=$symptomBName Create (s)-[:complication]->(db)")
    void insertRelComplicationSTS(@Param("symptomAName") String symptomAName, @Param("symptomBName") String symptomBName);

    /**
     * 插入并发症关系
     *
     * @param symptomName 症状名
     * @param diseaseName 疾病名
     */
    @Query("Match(s:Symptom),(d:Disease) where s.name=$symptomName AND d.name=$diseaseName Create (s)-[:complication]->(d)")
    void insertRelComplicationSTD(@Param("symptomName") String symptomName, @Param("diseaseName") String diseaseName);

    /**
     * 插入并发症关系
     *
     * @param symptomName      症状名
     * @param complicationName 并发症名
     */
    @Query("Match(s:Symptom),(c:Complication) where s.name=$symptomName AND c.name=$complicationName Create (s)-[:complication]->(c)")
    void insertRelComplicationSTC(@Param("symptomName") String symptomName, @Param("complicationName") String complicationName);

    /**
     * 插入相关导致关系
     *
     * @param symptomName   症状名
     * @param relatedToName 并发症名
     */
    @Query("Match(s:Symptom),(r:RelatedTo) where s.name=$symptomName AND r.name=$relatedToName Create (s)-[:relatedTo]->(r)")
    void insertRelRelatedTo(@Param("symptomName") String symptomName, @Param("relatedToName") String relatedToName);

    /**
     * 插入疾病实体 临床症状及体征
     *
     * @param symptomName 症状名A
     * @param diseaseName 疾病实体  临床症状及体征名
     */
    @Query("Match(s:Symptom),(d:Disease) where s.name=$symptomName AND d.name=$diseaseName  Create (s)-[:symptomAndSign]->(d)")
    void insertRelSymptomAndSignSTD(@Param("symptomName") String symptomName, @Param("diseaseName") String diseaseName);

    /**
     * 插入症状实体 临床症状及体征
     *
     * @param symptomAName 症状名
     * @param symptomBName 症状名B
     */
    @Query("Match(sa:Symptom),(sb:Symptom) where sa.name=$symptomAName AND sb.name=$symptomBName Create (sa)-[:symptomAndSign]->(sb)")
    void insertRelSymptomAndSignSTS(@Param("symptomAName") String symptomAName, @Param("symptomBName") String symptomBName);

    /**
     * 插入临床症状及体征实体 临床症状及体征
     *
     * @param symptomName        症状名
     * @param symptomAndSignName 临床症状及体征实体 临床症状及体征名
     */
    @Query("Match(s:Symptom),(sas:SymptomAndSign) where s.name=$symptomName AND sas.name=$symptomAndSignName Create (s)-[:symptomAndSign]->(sas)")
    void insertRelSymptomAndSignSTSAS(@Param("symptomName") String symptomName, @Param("symptomAndSignName") String symptomAndSignName);

    /**
     * 插入辅助检查关系
     *
     * @param symptomName 症状名
     * @param checkName   检查名
     */
    @Query("Match(s:Symptom),(c:Check) where s.name=$symptomName AND c.name=$checkName Create (s)-[:auxiliaryExamination]->(c)")
    void insertRelAuxiliaryExaminationSTC(@Param("symptomName") String symptomName, @Param("checkName") String checkName);

    /**
     * 插入辅助检查关系
     *
     * @param symptomName              症状名
     * @param auxiliaryExaminationName 辅助检查名
     */
    @Query("Match(s:Symptom),(a:AuxiliaryExamination) where s.name=$symptomName AND a.name=$auxiliaryExaminationName Create (s)-[:auxiliaryExamination]->(a)")
    void insertRelAuxiliaryExaminationSTA(@Param("symptomName") String symptomName, @Param("auxiliaryExaminationName") String auxiliaryExaminationName);

    /**
     * 插入辅助检查关系
     *
     * @param symptomName      症状名
     * @param checkSubjectName 检查科目名
     */
    @Query("Match(s:Symptom),(cs:CheckSubject) where s.name=$symptomName AND cs.name=$checkSubjectName Create (s)-[:auxiliaryExamination]->(cs)")
    void insertRelAuxiliaryExaminationSTCS(@Param("symptomName") String symptomName, @Param("checkSubjectName") String checkSubjectName);

    /**
     * 插入药名实体 药物治疗
     *
     * @param symptomName 症状名
     * @param drugName    药名实体 药物治疗名
     */
    @Query("Match(s:Symptom),(d:Drug) where s.name=$symptomName AND d.name=$drugName Create (s)-[:drugTherapy]->(d)")
    void insertRelDrugTherapySTD(@Param("symptomName") String symptomName, @Param("drugName") String drugName);

    /**
     * 插入药物治疗实体 药物治疗
     *
     * @param symptomName     症状名
     * @param drugTherapyName 药物治疗实体 药物治疗名
     */
    @Query("Match(s:Symptom),(d:DrugTherapy) where s.name=$symptomName AND d.name=$drugTherapyName Create (s)-[:drugTherapy]->(d)")
    void insertRelDrugTherapySTDT(@Param("symptomName") String symptomName, @Param("drugTherapyName") String drugTherapyName);

    /**
     * 插入阶段实体 阶段
     *
     * @param symptomName 症状名
     * @param stageName   阶段实体 阶段名
     */
    @Query("Match(s:Symptom),(st:Stage) where s.name=$symptomName AND st.name=$stageName Create (s)-[:stage]->(st)")
    void insertRelStage(@Param("symptomName") String symptomName, @Param("stageName") String stageName);

    /**
     * 插入多发群体实体 多发群体
     *
     * @param symptomName        症状名
     * @param multipleGroupsName 多发群体实体 多发群体名
     */
    @Query("Match(s:Symptom),(m:MultipleGroups) where s.name=$symptomName AND m.name=$multipleGroupsName Create (s)-[:multipleGroups]->(m)")
    void insertRelMultipleGroups(@Param("symptomName") String symptomName, @Param("multipleGroupsName") String multipleGroupsName);

}
