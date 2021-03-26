package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface DrugRelationRepository extends Neo4jRepository<Object, Integer> {
    /**
     * 插入成份关系
     *
     * @param drugName        药名
     * @param ingredientsName 成份名
     */
    @Query("Match(d:Drug),(i:Ingredients) where d.name=$drugName AND i.name=$ingredientsName Create (d)-[:ingredients]->(i)")
    void insertRelIngredientsDTI(@Param("drugName") String drugName, @Param("ingredientsName") String ingredientsName);

    /**
     * 插入OTC类型关系
     *
     * @param drugName 药名
     * @param OTCName  OTC类型名
     */
    @Query("Match(d:Drug),(o:OTC) where d.name=$drugName AND o.name=$OTCName Create (d)-[:OTCType]->(o)")
    void insertRelOTCDTO(@Param("drugName") String drugName, @Param("OTCName") String OTCName);

    /**
     * 插入不良反应关系
     *
     * @param drugName             药名
     * @param adverseReactionsName 不良反应名
     */
    @Query("Match(d:Drug),(a:AdverseReactions) where d.name=$drugName AND a.name=$adverseReactionsName Create (d)-[:adverseReactions]->(a)")
    void insertRelAdverseReactionsDTA(@Param("drugName") String drugName, @Param("adverseReactionsName") String adverseReactionsName);

    /**
     * 插入不良反应关系
     *
     * @param drugName    药名
     * @param diseaseName 疾病名
     */
    @Query("Match(d:Drug),(a:Disease) where d.name=$drugName AND a.name=$diseaseName Create (d)-[:adverseReactions]->(a)")
    void insertRelAdverseReactionsDTD(@Param("drugName") String drugName, @Param("diseaseName") String diseaseName);

    /**
     * 插入不良反应关系
     *
     * @param drugName    药名
     * @param symptomName 症状名
     */
    @Query("Match(d:Drug),(s:Symptom) where d.name=$drugName AND s.name=$symptomName Create (d)-[:adverseReactions]->(s)")
    void insertRelAdverseReactionsDTS(@Param("drugName") String drugName, @Param("symptomName") String symptomName);

    /**
     * 插入不良反应关系
     *
     * @param drugName         药名
     * @param complicationName 并发症名
     */
    @Query("Match(d:Drug),(c:Complication) where d.name=$drugName AND c.name=$complicationName Create (d)-[:adverseReactions]->(c)")
    void insertRelAdverseReactionsDTE(@Param("drugName") String drugName, @Param("complicationName") String complicationName);


    /**
     * 插入适应症关系
     *
     * @param drugName        药名
     * @param indicationsName 适应症名
     */
    @Query("Match(d:Drug),(i:Indications) where d.name=$drugName AND i.name=$indicationsName Create (d)-[:indications]->(i)")
    void insertRelIndicationsDTI(@Param("drugName") String drugName, @Param("indicationsName") String indicationsName);

    /**
     * 插入适应症关系
     *
     * @param drugName    药名
     * @param diseaseName 疾病名
     */
    @Query("Match(d:Drug),(a:Disease) where d.name=$drugName AND a.name=$diseaseName Create (d)-[:indications]->(a)")
    void insertRelIndicationsDTD(@Param("drugName") String drugName, @Param("diseaseName") String diseaseName);

    /**
     * 插入适应症关系
     *
     * @param drugName    药名
     * @param symptomName 症状名
     */
    @Query("Match(d:Drug),(s:Symptom) where d.name=$drugName AND s.name=$symptomName Create (d)-[:indications]->(s)")
    void insertRelIndicationsDTS(@Param("drugName") String drugName, @Param("symptomName") String symptomName);

    /**
     * 插入适应症关系
     *
     * @param drugName         药名
     * @param complicationName 并发症名
     */
    @Query("Match(d:Drug),(c:Complication) where d.name=$drugName AND c.name=$complicationName Create (d)-[:indications]->(c)")
    void insertRelIndicationsDTE(@Param("drugName") String drugName, @Param("complicationName") String complicationName);

    /**
     * 插入分类关系
     *
     * @param drugName 药名
     * @param typeName 分类名称
     */
    @Query("Match(d:Drug),(t:Type) where d.name=$drugName AND t.name=$typeName Create (d)-[:type]->(t)")
    void insertRelTypeDTT(@Param("drugName") String drugName, @Param("typeName") String typeName);

    /**
     * 插入注意事项关系
     *
     * @param drugName        药名
     * @param precautionsName 注意事项名称
     */
    @Query("Match(d:Drug),(p:Precautions) where d.name=$drugName AND p.name=$precautionsName Create (d)-[:precautions]->(p)")
    void insertRelPrecautionsDTP(@Param("drugName") String drugName, @Param("precautionsName") String precautionsName);

    /**
     * 插入禁忌证关系
     *
     * @param drugName              药名
     * @param contraindicationsName 禁忌证名称
     */
    @Query("Match(d:Drug),(c:Contraindications) where d.name=$drugName AND c.name=$contraindicationsName Create (d)-[:contraindications]->(c)")
    void insertRelContraindicationsDTC(@Param("drugName") String drugName, @Param("contraindicationsName") String contraindicationsName);

    /**
     * 插入禁忌证关系
     *
     * @param drugName    药名
     * @param diseaseName 疾病名
     */
    @Query("Match(d:Drug),(a:Disease) where d.name=$drugName AND a.name=$diseaseName Create (d)-[:contraindications]->(a)")
    void insertRelContraindicationsDTD(@Param("drugName") String drugName, @Param("diseaseName") String diseaseName);

    /**
     * 插入禁忌证关系
     *
     * @param drugName    药名
     * @param symptomName 症状名
     */
    @Query("Match(d:Drug),(s:Symptom) where d.name=$drugName AND s.name=$symptomName Create (d)-[:contraindications]->(s)")
    void insertRelContraindicationsDTS(@Param("drugName") String drugName, @Param("symptomName") String symptomName);

    /**
     * 插入禁忌证关系
     *
     * @param drugName         药名
     * @param complicationName 并发症名
     */
    @Query("Match(d:Drug),(c:Complication) where d.name=$drugName AND c.name=$complicationName Create (d)-[:contraindications]->(c)")
    void insertRelContraindicationsDTE(@Param("drugName") String drugName, @Param("complicationName") String complicationName);

    /**
     * 插入所属科目关系
     *
     * @param drugName    药名
     * @param subjectName 所属科目名称
     */
    @Query("Match(d:Drug),(s:Subject) where d.name=$drugName AND s.name=$subjectName Create (d)-[:subject]->(s)")
    void insertRelSubjectDTS(@Param("drugName") String drugName, @Param("subjectName") String subjectName);
}
