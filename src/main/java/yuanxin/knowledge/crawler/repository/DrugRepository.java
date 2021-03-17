package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author huyuanxin
 */
@Repository
public interface DrugRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化Drug,设置Drug的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (d:Drug) ASSERT d.name IS UNIQUE")
    void initDrug();

    /**
     * 插入疾病
     *
     * @param drugName 药品名称
     */
    @Query("CREATE (d:Drug) SET d.name= $drugName")
    void insertDrug(@Param("drugName") String drugName);

    /**
     * 返回特点名称药品的数量,作为是否存在的判断
     *
     * @param drugName 药品名称
     * @return 存在的数量
     */
    @Query("match(d:Drug) where d.name=$drugName return COUNT(*)")
    long isExits(@Param("drugName") String drugName);
}
