package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface RelatedSymptomRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化相关症状
     */
    @Query("CREATE CONSTRAINT ON (c:RelatedSymptom) ASSERT c.name IS UNIQUE")
    void initRelatedSymptom();

    /**
     * 查询指定名字的相关症状的个数
     *
     * @param relatedSymptomName 相关症状的名字
     * @return 个数
     */
    @Query("match(c:RelatedSymptom) where c.name=$relatedSymptomName return COUNT(*)")
    long isExits(@Param("relatedSymptomName") String relatedSymptomName);

    /**
     * 插入相关症状
     *
     * @param relatedSymptomName 相关症状的名字
     * @return 结果
     */
    @Query("CREATE (c:RelatedSymptom) SET c.name= $relatedSymptomName")
    void insertRelatedSymptom(@Param("relatedSymptomName") String relatedSymptomName);
}
