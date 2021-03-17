package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author huyuanxin
 */
public interface EntityRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化并发症
     */
    @Query("CREATE CONSTRAINT ON (c:Complication) ASSERT c.name IS UNIQUE")
    void initComplication();

    /**
     * 查询指定名字的并发症的个数
     *
     * @param complicationName 并发症的名字
     * @return 个数
     */
    @Query("match(c:Complication) where c.name=$complicationName return COUNT(*)")
    long complicationIsExits(@Param("complicationName") String complicationName);

    /**
     * 插入并发症
     *
     * @param complicationName 并发症的名字
     * @return 结果
     */
    @Query("CREATE (c:Complication) SET c.name= complicationName")
    void insertComplication(@Param("complicationName") String complicationName);
}
