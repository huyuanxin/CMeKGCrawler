package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface DiagnosisRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化鉴别诊断
     */
    @Query("CREATE CONSTRAINT ON (c:Diagnosis) ASSERT c.name IS UNIQUE")
    void initDiagnosis();

    /**
     * 查询指定名字的鉴别诊断的个数
     *
     * @param diagnosisName 鉴别诊断的名字
     * @return 个数
     */
    @Query("match(c:Diagnosis) where c.name=$diagnosisName return COUNT(*)")
    long isExits(@Param("diagnosisName") String diagnosisName);

    /**
     * 插入鉴别诊断
     *
     * @param diagnosisName 鉴别诊断的名字
     * @return 结果
     */
    @Query("CREATE (c:Diagnosis) SET c.name= $diagnosisName")
    void insertDiagnosis(@Param("diagnosisName") String diagnosisName);
}
