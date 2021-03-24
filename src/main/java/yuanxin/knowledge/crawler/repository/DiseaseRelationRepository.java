package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author huyuanxin
 */
public interface DiseaseRelationRepository extends Neo4jRepository<Object, Integer> {
    /**
     * 插入并发症关系
     *
     * @param diseaseAName 疾病名A
     * @param diseaseBName 疾病名B
     */
    @Query("Match(da:Disease),(db:Disease) where da.name=$diseaseAName AND db.name=$diseaseBName Create (da)-[complication]->(db)")
    void insertRelComplicationDTD(@Param("diseaseAName") String diseaseAName, @Param("diseaseBName") String diseaseBName);

    /**
     * 插入并发症关系
     *
     * @param diseaseName 疾病名
     * @param symptomName 症状名
     */

    @Query("Match(d:Disease),(s:Symptom) where d.name=$diseaseName AND s.name=$symptomName Create (d)-[complication]->(s)")
    void insertRelComplicationDTS(@Param("diseaseName") String diseaseName, @Param("symptomName") String symptomName);

    /**
     * 插入并发症关系
     *
     * @param diseaseName      疾病名
     * @param complicationName 并发症名
     */
    @Query("Match(d:Disease),(c:Complication) where d.name=$diseaseName AND c.name=$complicationName Create (d)-[complication]->(c)")
    void insertRelComplicationDTC(@Param("diseaseName") String diseaseName, @Param("complicationName") String complicationName);

    /**
     * 插入病理生理关系
     *
     * @param diseaseAName 疾病名A
     * @param diseaseBName 疾病名B
     */
    @Query("Match(da:Disease),(db:Disease) where da.name=$diseaseAName AND db.name=$diseaseBName Create (da)-[pathophysiology]->(db)")
    void insertRelPathophysiologyDTD(@Param("diseaseAName") String diseaseAName, @Param("diseaseBName") String diseaseBName);

    /**
     * 插入病理生理关系
     *
     * @param diseaseName 疾病名
     * @param symptomName 症状名
     */

    @Query("Match(d:Disease),(s:Symptom) where d.name=$diseaseName AND s.name=$symptomName Create (d)-[pathophysiology]->(s)")
    void insertRelPathophysiologyDTS(@Param("diseaseName") String diseaseName, @Param("symptomName") String symptomName);

    /**
     * 插入病理生理关系
     *
     * @param diseaseName         疾病名
     * @param pathophysiologyName 病理生理名
     */
    @Query("Match(d:Disease),(p:Pathophysiology) where d.name=$diseaseName AND p.name=$pathophysiologyName Create (d)-[pathophysiology]->(p)")
    void insertRelPathophysiologyDTP(@Param("diseaseName") String diseaseName, @Param("pathophysiologyName") String pathophysiologyName);

    /**
     * 插入发病部位关系
     *
     * @param diseaseAName 疾病名A
     * @param diseaseBName 疾病名B
     */
    @Query("Match(da:Disease),(db:Disease) where da.name=$diseaseAName AND db.name=$diseaseBName Create (da)-[diseaseSite]->(db)")
    void insertRelDiseaseSiteDTD(@Param("diseaseAName") String diseaseAName, @Param("diseaseBName") String diseaseBName);

    /**
     * 插入发病部位关系
     *
     * @param diseaseName 疾病名
     * @param symptomName 症状名
     */

    @Query("Match(d:Disease),(s:Symptom) where d.name=$diseaseName AND s.name=$symptomName Create (d)-[diseaseSite]->(s)")
    void insertRelDiseaseSiteDTS(@Param("diseaseName") String diseaseName, @Param("symptomName") String symptomName);


    /**
     * 插入发病部位关系
     *
     * @param diseaseName     疾病名
     * @param diseaseSiteName 发病部位名
     */

    @Query("Match(d:Disease),(p:DiseaseSite) where d.name=$diseaseName AND p.name=$diseaseSiteName Create (d)-[diseaseSite]->(p)")
    void insertRelDiseaseSiteDTP(@Param("diseaseName") String diseaseName, @Param("diseaseSiteName") String diseaseSiteName);

    /**
     * 插入所属科室关系
     *
     * @param diseaseName    疾病名
     * @param departmentName 所属科室名
     */

    @Query("Match(d:Disease),(p:Department) where d.name=$diseaseName AND p.name=$departmentName Create (d)-[department]->(p)")
    void insertRelDepartmentDTD(@Param("diseaseName") String diseaseName, @Param("departmentName") String departmentName);

    /**
     * 插入多发群体关系
     *
     * @param diseaseName        疾病名
     * @param multipleGroupsName 所属科室名
     */

    @Query("Match(d:Disease),(m: MultipleGroups) where d.name=$diseaseName AND m.name=$multipleGroupsName Create (d)-[multipleGroups]->(m)")
    void insertRelMultipleGroupsDTM(@Param("diseaseName") String diseaseName, @Param("multipleGroupsName") String multipleGroupsName);

    /**
     * 插入病因关系
     *
     * @param diseaseAName 疾病名A
     * @param diseaseBName 疾病名B
     */
    @Query("Match(da:Disease),(db:Disease) where da.name=$diseaseAName AND db.name=$diseaseBName Create (da)-[cause]->(db)")
    void insertRelCauseDTD(@Param("diseaseAName") String diseaseAName, @Param("diseaseBName") String diseaseBName);

    /**
     * 插入病因关系
     *
     * @param diseaseName 疾病名
     * @param causeName   病因名
     */
    @Query("Match(d:Disease),(c: Cause) where d.name=$diseaseName AND c.name=$causeName Create (d)-[cause]->(c)")
    void insertRelCauseDTC(@Param("diseaseName") String diseaseName, @Param("causeName") String causeName);

    /**
     * 插入预后生存时间关系
     *
     * @param diseaseName                疾病名
     * @param prognosticSurvivalTimeName 预后生存时间名
     */
    @Query("Match(d:Disease),(p: PrognosticSurvivalTime) where d.name=$diseaseName AND p.name=$prognosticSurvivalTimeName Create (d)-[prognosticSurvivalTime]->(p)")
    void insertRelPrognosticSurvivalTimeDTP(@Param("diseaseName") String diseaseName, @Param("prognosticSurvivalTimeName") String prognosticSurvivalTimeName);

    /**
     * 插入高危因素关系
     *
     * @param diseaseName         疾病名
     * @param highRiskFactorsName 高危因素名
     */
    @Query("Match(d:Disease),(h: HighRiskFactors) where d.name=$diseaseName AND h.name=$highRiskFactorsName Create (d)-[highRiskFactors]->(h)")
    void insertRelHighRiskFactorsDTH(@Param("diseaseName") String diseaseName, @Param("highRiskFactorsName") String highRiskFactorsName);

    /**
     * 插入相关疾病关系
     *
     * @param diseaseAName 疾病名A
     * @param diseaseBName 疾病名B
     */
    @Query("Match(da:Disease),(db:Disease) where da.name=$diseaseAName AND db.name=$diseaseBName Create (da)-[relatedDisease]->(db)")
    void insertRelRelatedDiseaseDTD(@Param("diseaseAName") String diseaseAName, @Param("diseaseBName") String diseaseBName);

    /**
     * 插入相关疾病关系
     *
     * @param diseaseName        疾病名
     * @param relatedDiseaseName 相关疾病名
     */
    @Query("Match(d:Disease),(r: RelatedDisease) where d.name=$diseaseName AND r.name=$relatedDiseaseName Create (d)-[relatedDisease]->(r)")
    void insertRelRelatedDiseaseDTR(@Param("diseaseName") String diseaseName, @Param("relatedDiseaseName") String relatedDiseaseName);

    /**
     * 插入相关症状关系
     *
     * @param diseaseName        疾病名
     * @param relatedSymptomName 相关症状名
     */
    @Query("Match(d:Disease),(r: RelatedSymptom) where d.name=$diseaseName AND r.name=$relatedSymptomName Create (d)-[relatedSymptom]->(r)")
    void insertRelRelatedSymptomDTR(@Param("diseaseName") String diseaseName, @Param("relatedSymptomName") String relatedSymptomName);

    /**
     * 插入相关症状关系
     *
     * @param diseaseName 疾病名
     * @param symptomName 症状名
     */

    @Query("Match(d:Disease),(s:Symptom) where d.name=$diseaseName AND s.name=$symptomName Create (d)-[relatedSymptom]->(s)")
    void insertRelRelatedSymptomDTS(@Param("diseaseName") String diseaseName, @Param("symptomName") String symptomName);

    /**
     * 插入治疗方案关系
     *
     * @param diseaseName         疾病名
     * @param adjuvantTherapyName 辅助治疗名
     */
    @Query("Match(d:Disease),(a: AdjuvantTherapy) where d.name=$diseaseName AND a.name=$adjuvantTherapyName Create (d)-[treatmentPrograms]->(a)")
    void insertRelTreatmentProgramsDTA(@Param("diseaseName") String diseaseName, @Param("adjuvantTherapyName") String adjuvantTherapyName);

    /**
     * 插入治疗方案关系
     *
     * @param diseaseName     疾病名
     * @param drugTherapyName 药物治疗名
     */
    @Query("Match(d:Disease),(u: DrugTherapy) where d.name=$diseaseName AND u.name=$drugTherapyName Create (d)-[treatmentPrograms]->(u)")
    void insertRelTreatmentProgramsDTU(@Param("diseaseName") String diseaseName, @Param("drugTherapyName") String drugTherapyName);

    /**
     * 插入治疗方案关系
     *
     * @param diseaseName   疾病名
     * @param operationName 手术治疗名
     */
    @Query("Match(d:Disease),(o:Operation) where d.name=$diseaseName AND o.name=$operationName Create (d)-[treatmentPrograms]->(o)")
    void insertRelTreatmentProgramsDTO(@Param("diseaseName") String diseaseName, @Param("operationName") String operationName);

    /**
     * 插入治疗方案关系
     *
     * @param diseaseName 疾病名
     * @param drugName    药名
     */
    @Query("Match(da:Disease),(db: Drug) where da.name=$diseaseName AND db.name=$drugName Create (da)-[treatmentPrograms]->(db)")
    void insertRelTreatmentProgramsDTD(@Param("diseaseName") String diseaseName, @Param("drugName") String drugName);

    /**
     * 插入治疗方案关系
     *
     * @param diseaseName   疾病名
     * @param treatmentName 诊疗名
     */
    @Query("Match(d:Disease),(t:Treatment) where d.name=$diseaseName AND t.name=$treatmentName Create (d)-[treatmentPrograms]->(t)")
    void insertRelTreatmentProgramsDTT(@Param("diseaseName") String diseaseName, @Param("treatmentName") String treatmentName);

    /**
     * 插入治疗方案关系
     *
     * @param diseaseName 疾病名
     * @param checkName   检查名
     */
    @Query("Match(d:Disease),(c:Check) where d.name=$diseaseName AND c.name=$checkName Create (d)-[treatmentPrograms]->(c)")
    void insertRelTreatmentProgramsDTC(@Param("diseaseName") String diseaseName, @Param("checkName") String checkName);

    /**
     * 插入治疗方案关系
     *
     * @param diseaseName              疾病名
     * @param auxiliaryExaminationName 辅助检查名
     */
    @Query("Match(d:Disease),(a:AuxiliaryExamination) where d.name=$diseaseName AND a.name=$auxiliaryExaminationName Create (d)-[treatmentPrograms]->(a)")
    void insertRelTreatmentProgramsDTE(@Param("diseaseName") String diseaseName, @Param("auxiliaryExaminationName") String auxiliaryExaminationName);

//临床症状及体征

    /**
     * 插入疾病实体 临床症状及体征
     *
     * @param diseaseAName 疾病名
     * @param diseaseBName 疾病实体 临床症状及体征名
     */
    @Query("Match(da:Disease),(db:Disease) where da.name=$diseaseAName AND db.name=$diseaseBName Create (da)-[symptomAndSign]->(db)")
    void insertRelSymptomAndSignDTD(@Param("diseaseAName") String diseaseAName, @Param("diseaseBName") String diseaseBName);

    /**
     * 插入症状实体并发症
     *
     * @param diseaseName 疾病名
     * @param symptomName 症状实体 临床症状及体征名
     */
    @Query("Match(d:Disease),(s:Symptom) where d.name=$diseaseName AND s.name=$symptomName Create (d)-[symptomAndSign]->(s)")
    void insertRelSymptomAndSignDTS(@Param("diseaseName") String diseaseName, @Param("symptomName") String symptomName);

    /**
     * 插入并发症实体并发症
     *
     * @param diseaseName        疾病名
     * @param symptomAndSignName 临床症状及体征实体 临床症状及体征名
     */
    @Query("Match(d:Disease),(s:SymptomAndSign) where d.name=$diseaseName AND s.name=$symptomAndSignName Create (d)-[symptomAndSign]->(s)")
    void insertRelSymptomAndSignDTSAS(@Param("diseaseName") String diseaseName, @Param("symptomAndSignName") String symptomAndSignName);

    //预后状况

    /**
     * 插入预后状况实体 预后状况
     *
     * @param diseaseName   疾病名
     * @param prognosisName 预后状况实体 预后状况名
     */
    @Query("Match(d:Disease),(p:Prognosis) where da.name=$diseaseName AND p.name=$prognosisName Create (d)-[prognosis]->(p)")
    void insertRelPrognosis(@Param("diseaseName") String diseaseName, @Param("prognosisName") String prognosisName);

    //发病率

    /**
     * 插入属性实体 发病率
     *
     * @param diseaseName   疾病名
     * @param attributeName 症状实体 发病率名
     */
    @Query("Match(d:Disease),(a:Attribute) where d.name=$diseaseName AND a.name=$attributeName Create (d)-[diseaseRate]->(a)")
    void insertRelDiseaseRateDTA(@Param("diseaseName") String diseaseName, @Param("attributeName") String attributeName);

    /**
     * 插入发病率实体 发病率
     *
     * @param diseaseName     疾病名
     * @param diseaseRateName 发病率实体 发病率名
     */
    @Query("Match(d:Disease),(dr:DiseaseRate) where d.name=$diseaseName AND dr.name=$diseaseRateName Create (d)-[diseaseRate]->(dr)")
    void insertRelDiseaseRateDTDR(@Param("diseaseName") String diseaseName, @Param("diseaseRateName") String diseaseRateName);

    //药物治疗

    /**
     * 插入属性实体 药物治疗
     *
     * @param diseaseName 疾病名
     * @param drugName    属性实体 药物治疗名
     */
    @Query("Match(d:Disease),(dg:Drug) where d.name=$diseaseName AND dg.name=$drugName Create (d)-[drugTherapy]->(dg)")
    void insertRelDrugTherapyDTD(@Param("diseaseName") String diseaseName, @Param("drugName") String drugName);

    /**
     * 插入药物治疗实体 发病率
     *
     * @param diseaseName     疾病名
     * @param drugTherapyName 药物治疗实体 药物治疗名
     */
    @Query("Match(d:Disease),(dr:DrugTherapy) where d.name=$diseaseName AND dt.name=$drugTherapyName Create (d)-[drugTherapy]->(dt)")
    void insertRelDrugTherapyDTDT(@Param("diseaseName") String diseaseName, @Param("drugTherapyName") String drugTherapyName);

    //辅助治疗

    /**
     * 插入症状实体 辅助治疗
     *
     * @param diseaseName   疾病名
     * @param treatmentName 药品实体 药物治疗名
     */
    @Query("Match(d:Disease),(t:Treatment) where d.name=$diseaseName AND t.name=$treatmentName Create (d)-[adjuvantTherapy]->(t)")
    void insertRelAdjuvantTherapyDTT(@Param("diseaseName") String diseaseName, @Param("treatmentName") String treatmentName);

    /**
     * 插入药物治疗实体 辅助治疗
     *
     * @param diseaseName         疾病名
     * @param adjuvantTherapyName 药物治疗实体 药物治疗名
     */
    @Query("Match(d:Disease),(a:AdjuvantTherapy) where d.name=$diseaseName AND a.name=$adjuvantTherapyName Create (d)-[adjuvantTherapy]->(a)")
    void insertRelAdjuvantTherapyDTA(@Param("diseaseName") String diseaseName, @Param("adjuvantTherapyName") String adjuvantTherapyName);

    //手术治疗

    /**
     * 插入症状实体 手术治疗
     *
     * @param diseaseName   疾病名
     * @param treatmentName 药品实体 药物治疗名
     */
    @Query("Match(d:Disease),(t:Treatment) where d.name=$diseaseName AND t.name=$treatmentName Create (d)-[operation]->(t)")
    void insertRelOperationDTT(@Param("diseaseName") String diseaseName, @Param("treatmentName") String treatmentName);

    /**
     * 插入手术治疗实体 手术治疗
     *
     * @param diseaseName   疾病名
     * @param operationName 药物治疗实体 药物治疗名
     */
    @Query("Match(d:Disease),(o:Operation) where d.name=$diseaseName AND o.name=$operationName Create (d)-[operation]->(o)")
    void insertRelOperationDTO(@Param("diseaseName") String diseaseName, @Param("operationName") String operationName);

    //发病机制

    /**
     * 插入发病机制实体 发病机制
     *
     * @param diseaseName      疾病名
     * @param pathogenesisName 发病机制实体 发病机制名
     */
    @Query("Match(d:Disease),(p:Pathogenesis) where d.name=$diseaseName AND p.name=$pathogenesisName Create (d)-[pathogenesis]->(p)")
    void insertRelPathogenesisDTO(@Param("diseaseName") String diseaseName, @Param("pathogenesisName") String pathogenesisName);

    //病理分型

    /**
     * 插入病理分型实体 病理分型
     *
     * @param diseaseName          疾病名
     * @param pathologicalTypeName 病理分型实体 病理分型名
     */
    @Query("Match(d:Disease),(p:PathologicalType) where d.name=$diseaseName AND p.name=$pathologicalTypeName Create (d)-[pathologicalType]->(p)")
    void insertRelPathologicalTypeDTO(@Param("diseaseName") String diseaseName, @Param("pathologicalTypeName") String pathologicalTypeName);

    //鉴别诊断

    /**
     * 插入诊疗实体 鉴别诊断
     *
     * @param diseaseName   疾病名
     * @param treatmentName 诊疗实体 鉴别诊断名
     */
    @Query("Match(d:Disease),(t:Treatment) where d.name=$diseaseName AND t.name=$treatmentName Create (d)-[diagnosis]->(t)")
    void insertRelDiagnosisDTT(@Param("diseaseName") String diseaseName, @Param("treatmentName") String treatmentName);

    /**
     * 插入鉴别诊断实体 鉴别诊断
     *
     * @param diseaseName   疾病名
     * @param diagnosisName 鉴别诊断实体 鉴别诊断名
     */
    @Query("Match(d:Disease),(di:Diagnosis) where d.name=$diseaseName AND di.name=$diagnosisName Create (d)-[diagnosis]->(di)")
    void insertRelDiagnosisDTDI(@Param("diseaseName") String diseaseName, @Param("diagnosisName") String diagnosisName);


}
