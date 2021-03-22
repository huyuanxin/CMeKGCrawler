package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface PathophysiologyRepository extends Neo4jRepository<Object, Integer> {
    /**
     * 初始化病理生理
     */
    @Query("CREATE CONSTRAINT ON (c:Pathophysiology) ASSERT c.name IS UNIQUE")
    void initPathophysiology();

    /**
     * 查询指定名字的病理生理的个数
     *
     * @param pathophysiologyName 病理生理的名字
     * @return 个数
     */
    @Query("match(c:Pathophysiology) where c.name=$pathophysiologyName return COUNT(*)")
    long isExits(@Param("pathophysiologyName") String pathophysiologyName);

    /**
     * 插入病理生理
     *
     * @param pathophysiologyName 病理生理的名字
     * @return 结果
     */
    @Query("CREATE (c:Pathophysiology) SET c.name= $pathophysiologyName")
    void insertPathophysiology(@Param("pathophysiologyName") String pathophysiologyName);
}
