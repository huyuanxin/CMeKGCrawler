package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * @author ztt
 */
@Repository
public interface PathogenesisRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化Pathogenesis,设置Pathogenesis的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (p:Pathogenesis) ASSERT p.name IS UNIQUE")
    void initPathogenesis();

    /**
     * 插入发病机制
     *
     * @param pathogenesisName 发病机制名称
     */
    @Query("CREATE (p:Pathogenesis) SET p.name= $pathogenesisName")
    void insertPathogenesis(@Param("pathogenesisName") String pathogenesisName);

    /**
     * 返回特定名称发病机制的数量,作为是否存在的判断
     * * @param pathogenesisName 发病机制名称
     *
     * @return 存在的数量
     */
    @Query("match(p:Pathogenesis) where p.name= $pathogenesisName return COUNT(*)")
    long isExits(@Param("pathogenesisName") String pathogenesisName);
}
