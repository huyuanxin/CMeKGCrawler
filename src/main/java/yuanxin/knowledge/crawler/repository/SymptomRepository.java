package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author huyuanxin
 */
@Repository
public interface SymptomRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化Symptom,设置Symptom的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (s:Symptom) ASSERT s.name IS UNIQUE")
    void initSymptom();

    /**
     * 插入疾病
     *
     * @param symptomName 症状名称
     */
    @Query("CREATE (s:Symptom) SET s.name= $symptomName")
    void insertSymptom(@Param("symptomName") String symptomName);

    /**
     * 返回特点名称疾病的数量,作为是否存在的判断
     *
     * @param symptomName 症状名称
     * @return 存在的数量
     */
    @Query("match(s:Symptom) where s.name=$symptomName return COUNT(*)")
    long isExits(@Param("symptomName") String symptomName);
}
