package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * @author ztt
 */
@Repository
public interface DrugTherapyRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化DrugTherapy,设置DrugTherapy的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (d:DrugTherapy) ASSERT d.name IS UNIQUE")
    void initDrugTherapy();

    /**
     * 插入药物治疗
     *
     * @param drugTherapyName 药物治疗名称
     */
    @Query("CREATE (d:DrugTherapy) SET d.name= $drugTherapyName")
    void insertDrugTherapy(@Param("drugTherapyName") String drugTherapyName);

    /**
     * 返回特点名称药物治疗的数量,作为是否存在的判断
     *
     * @param drugTherapyName 药物治疗名称
     * @return 存在的数量
     */
    @Query("match(d:DrugTherapy) where d.name=$drugTherapyName return COUNT(*)")
    long isExits(@Param("drugTherapyName") String drugTherapyName);
}