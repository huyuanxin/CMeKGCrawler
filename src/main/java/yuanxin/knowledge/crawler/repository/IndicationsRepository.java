package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * 药物-适应症
 * @author ztt
 */
@Repository
public interface IndicationsRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化Indications,设置Indications的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (i:Indications) ASSERT i.name IS UNIQUE")
    void initIndications();

    /**
     * 插入Indications
     *
     * @param indicationsName 适应症名称
     */
    @Query("CREATE (i:Indications) SET i.name= $indicationsName")
    void insertIndications(@Param("indicationsName") String indicationsName);

    /**
     * 返回特定名称适应症的数量,作为是否存在的判断
     * @param indicationsName 适应症名称
     * @return 存在的数量
     */
    @Query("match(i:Indications) where i.name= $indicationsName return COUNT(*)")
    long isExits(@Param("indicationsName") String indicationsName);
}


