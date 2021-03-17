package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author huyuanxin
 */
@Repository
public interface TreatmentRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化Treatment,设置Treatment的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (t:Treatment) ASSERT t.name IS UNIQUE")
    void initTreatment();

    /**
     * 插入诊疗
     *
     * @param treatmentName 名称
     */
    @Query("CREATE (t:Treatment) SET t.name= $treatmentName")
    void insertTreatment(@Param("treatmentName") String treatmentName);

    /**
     * 返回特点名称诊疗的数量,作为是否存在的判断
     *
     * @param treatmentName 诊疗名称
     * @return 存在的数量
     */
    @Query("match(t:Treatment) where t.name=$treatmentName return COUNT(*)")
    long isExits(@Param("treatmentName") String treatmentName);
}
