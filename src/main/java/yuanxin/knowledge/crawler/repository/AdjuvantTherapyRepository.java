package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * @author ztt
 */
@Repository
public interface AdjuvantTherapyRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化AdjuvantTherapy,设置AdjuvantTherapy的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (a:AdjuvantTherapy) ASSERT a.name IS UNIQUE")
    void initAdjuvantTherapy();

    /**
     * 插入辅助治疗
     *
     * @param adjuvantTherapyName 辅助治疗名称
     */
    @Query("CREATE (a:AdjuvantTherapy) SET a.name= $adjuvantTherapyName")
    void insertAdjuvantTherapy(@Param("adjuvantTherapyName") String adjuvantTherapyName);

    /**
     * 返回特定名称辅助治疗的数量,作为是否存在的判断
     * * @param adjuvantTherapyName 辅助治疗名称
     *
     * @return 存在的数量
     */
    @Query("match(a:AdjuvantTherapy) where a.name= $adjuvantTherapyName return COUNT(*)")
    long isExits(@Param("adjuvantTherapyName") String adjuvantTherapyName);
}