package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * 治疗方案
 * @author ztt
 */
@Repository
public interface TreatmentProgramsRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化TreatmentPrograms,设置TreatmentPrograms的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (t:TreatmentPrograms) ASSERT t.name IS UNIQUE")
    void initTreatmentPrograms();

    /**
     * 插入治疗方案
     *
     * @param treatmentProgramsName 治疗方案名称
     */
    @Query("CREATE (t:TreatmentPrograms) SET t.name= $treatmentProgramsName")
    void insertTreatmentPrograms(@Param("treatmentProgramsName") String treatmentProgramsName);

    /**
     * 返回特定名称治疗方案的数量,作为是否存在的判断
     * @param treatmentProgramsName 治疗方案名称
     * @return 存在的数量
     */
    @Query("match(t:TreatmentPrograms) where t.name= $treatmentProgramsName return COUNT(*)")
    long isExits(@Param("treatmentProgramsName") String treatmentProgramsName);
}
