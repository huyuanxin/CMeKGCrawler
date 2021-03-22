package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ztt
 */
@Repository
public interface PrognosisRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化Prognosis,设置Prognosis的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (p:Prognosis) ASSERT p.name IS UNIQUE")
    void initPrognosis();

    /**
     * 插入预后状况
     *
     * @param prognosisName 预后状况名称
     */
    @Query("CREATE (p:Prognosis) SET p.name= $prognosisName")
    void insertPrognosis(@Param("prognosisName") String prognosisName);

    /**
     * 返回特定名称预后状况的数量,作为是否存在的判断
     * * @param prognosisName 预后状况名称
     *
     * @return 存在的数量
     */
    @Query("match(p:Prognosis) where p.name= $prognosisName return COUNT(*)")
    long isExits(@Param("prognosisName") String prognosisName);
}
