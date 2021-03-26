package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface TreatmentRelationRepository extends Neo4jRepository<Object, Integer> {
    /**
     * 插入相关疾病关系
     *
     * @param treatmentName      诊疗名
     * @param relatedDiseaseName 相关疾病的名字
     */
    @Query("Match(t:Treatment),(r:RelatedDisease) where t.name=$treatmentName AND r.name=$relatedDiseaseName Create (t)-[:relatedDisease]->(r)")
    void insertRelRelatedDiseaseTTR(@Param("treatmentName") String treatmentName, @Param("relatedDiseaseName") String relatedDiseaseName);


    /**
     * 插入相关疾病关系
     *
     * @param treatmentName 诊疗名
     * @param diseaseName   疾病名
     */
    @Query("Match(t:Treatment),(d:Disease) where t.name=$treatmentName AND d.name=$diseaseName Create (t)-[:relatedDisease]->(d)")
    void insertRelRelatedDiseaseTTD(@Param("treatmentName") String treatmentName, @Param("diseaseName") String diseaseName);

    /**
     * 插入相关症状关系
     *
     * @param treatmentName      诊疗名
     * @param relatedSymptomName 相关症状名
     */
    @Query("Match(t:Treatment),(r: RelatedSymptom) where t.name=$treatmentName AND r.name=$relatedSymptomName Create (t)-[:relatedSymptom]->(r)")
    void insertRelRelatedSymptomTTR(@Param("treatmentName") String treatmentName, @Param("relatedSymptomName") String relatedSymptomName);

    /**
     * 插入相关症状关系
     *
     * @param treatmentName 诊疗名
     * @param symptomName   症状名
     */

    @Query("Match(t:Treatment),(s:Symptom) where t.name=$treatmentName AND s.name=$symptomName Create (t)-[:relatedSymptom]->(s)")
    void insertRelRelatedDiseaseTTS(@Param("treatmentName") String treatmentName, @Param("symptomName") String symptomName);

    /**
     * 插入检查科目关系
     *
     * @param treatmentName    诊疗名
     * @param checkSubjectName 检查科目的名字
     */

    @Query("Match(t:Treatment),(cs:CheckSubject) where t.name=$treatmentName AND cs.name=$checkSubjectName Create (t)-[:checkSubject]->(cs)")
    void insertRelCheckSubjectTTCS(@Param("treatmentName") String treatmentName, @Param("checkSubjectName") String checkSubjectName);

    /**
     * 插入检查科目关系
     *
     * @param treatmentName 诊疗名
     * @param checkName     检查的名字
     */

    @Query("Match(t:Treatment),(c:Check) where t.name=$treatmentName AND c.name=$checkName Create (t)-[:checkSubject]->(c)")
    void insertRelCheckSubjectTTC(@Param("treatmentName") String treatmentName, @Param("checkName") String checkName);

    /**
     * 插入检查科目关系
     *
     * @param treatmentName            诊疗名
     * @param auxiliaryExaminationName 辅助检查的名字
     */

    @Query("Match(t:Treatment),(a:AuxiliaryExamination) where t.name=$treatmentName AND a.name=$auxiliaryExaminationName Create (t)-[:checkSubject]->(a)")
    void insertRelCheckSubjectTTA(@Param("treatmentName") String treatmentName, @Param("auxiliaryExaminationName") String auxiliaryExaminationName);
}
