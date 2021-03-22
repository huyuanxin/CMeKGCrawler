package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 症状-预防
 * @author ztt
 */
@Repository
public interface PreventionRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化Prevention,设置Prevention的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (p:Prevention) ASSERT p.name IS UNIQUE")
    void initPrevention();

    /**
     * 插入预防
     *
     * @param preventionName 预防名称
     */
    @Query("CREATE (p:preventionName) SET p.name= $preventionName")
    void insertPrevention(@Param("treatmentProgramsName") String preventionName);

    /**
     * 返回特定名称预防的数量,作为是否存在的判断
     * @param preventionName 预防名称
     * @return 存在的数量
     */
    @Query("match(p:preventionName) where p.name= $preventionName return COUNT(*)")
    long isExits(@Param("preventionName") String preventionName);
}
