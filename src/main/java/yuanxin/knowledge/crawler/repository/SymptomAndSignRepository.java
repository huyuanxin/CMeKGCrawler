package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * @author ztt
 */
@Repository
public interface SymptomAndSignRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化SymptomAndSign,设置SymptomAndSign的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (s:SymptomAndSign) ASSERT s.name IS UNIQUE")
    void initSymptomAndSign();

    /**
     * 插入临床症状及体征
     *
     * @param symptomAndSignName 临床症状及体征名称
     */
    @Query("CREATE (s:SymptomAndSign) SET s.name= $symptomAndSignName")
    void insertSymptomAndSign(@Param("symptomAndSignName") String symptomAndSignName);

    /**
     * 返回特定名称临床症状及体征的数量,作为是否存在的判断
     * * @param symptomAndSignName 临床症状及体征名称
     *
     * @return 存在的数量
     */
    @Query("match(s:SymptomAndSign) where s.name= $symptomAndSignName return COUNT(*)")
    long isExits(@Param("symptomAndSignName") String symptomAndSignName);
}