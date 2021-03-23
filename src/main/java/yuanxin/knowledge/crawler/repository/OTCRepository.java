package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * 药物-OTC类型
 * @author ztt
 */
@Repository
public interface OTCRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化OTC,设置OTC的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (o:OTC) ASSERT o.name IS UNIQUE")
    void initOTC();

    /**
     * 插入OTC
     *
     * @param OTCName OTC名称
     */
    @Query("CREATE (o:OTC) SET o.name= $OTCName")
    void insertOTC(@Param("OTCName") String OTCName);

    /**
     * 返回特定名称OTC类型的数量,作为是否存在的判断
     * @param OTCName 成份名称
     * @return 存在的数量
     */
    @Query("match(o:OTC) where o.name= $OTCName return COUNT(*)")
    long isExits(@Param("OTCName") String OTCName);
}

