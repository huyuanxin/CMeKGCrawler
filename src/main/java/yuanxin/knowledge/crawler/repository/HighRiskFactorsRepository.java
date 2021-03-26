package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface HighRiskFactorsRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化高危因素
     */
    @Query("CREATE CONSTRAINT ON (c:Cause) ASSERT c.name IS UNIQUE")
    void initHighRiskFactors();

    /**
     * 查询指定名字的高危因素的个数
     *
     * @param highRiskFactorsName 高危因素的名字
     * @return 个数
     */
    @Query("match(c:HighRiskFactors) where c.name=$highRiskFactorsName return COUNT(*)")
    long isExits(@Param("highRiskFactorsName") String highRiskFactorsName);

    /**
     * 插入高危因素
     *
     * @param highRiskFactorsName 高危因素的名字
     * @return 结果
     */
    @Query("CREATE (c:HighRiskFactors) SET c.name= $highRiskFactorsName")
    void insertHighRiskFactors(@Param("highRiskFactorsName") String highRiskFactorsName);

}
