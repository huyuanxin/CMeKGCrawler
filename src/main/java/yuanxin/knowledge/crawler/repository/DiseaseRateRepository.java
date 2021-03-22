package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ztt
 */
@Repository
public interface DiseaseRateRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化DiseaseRate,设置DiseaseRate的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (d:DiseaseRate) ASSERT d.name IS UNIQUE")
    void initDiseaseRate();

    /**
     * 插入发病率
     *
     * @param diseaseRateName 发病率名称
     */
    @Query("CREATE (d:DiseaseRate) SET d.name= $diseaseRateName")
    void insertDiseaseRate(@Param("diseaseRateName") String diseaseRateName);

    /**
     * 返回特定名称发病率的数量,作为是否存在的判断
     * * @param diseaseRateName 发病率名称
     *
     * @return 存在的数量
     */
    @Query("match(d:DiseaseRate) where d.name= $diseaseRateName return COUNT(*)")
    long isExits(@Param("diseaseRateName") String diseaseRateName);
}