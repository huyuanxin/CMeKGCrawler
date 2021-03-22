package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface RelatedToRepository extends Neo4jRepository<Object, Integer> {
    /**
     * 初始化相关导致
     */
    @Query("CREATE CONSTRAINT ON (c:RelatedTo) ASSERT c.name IS UNIQUE")
    void initRelatedTo();

    /**
     * 查询指定名字的相关导致的个数
     *
     * @param relatedToName 相关导致的名字
     * @return 个数
     */
    @Query("match(c:RelatedTo) where c.name=$relatedToName return COUNT(*)")
    long isExits(@Param("relatedToName") String relatedToName);

    /**
     * 插入相关导致
     *
     * @param relatedToName 相关导致的名字
     * @return 结果
     */
    @Query("CREATE (c:RelatedTo) SET c.name= $relatedToName")
    void insertRelatedTo(@Param("relatedToName") String relatedToName);
}
