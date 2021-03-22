package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface CauseRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化病因
     */
    @Query("CREATE CONSTRAINT ON (c:Cause) ASSERT c.name IS UNIQUE")
    void initCause();

    /**
     * 查询指定名字的病因的个数
     *
     * @param causeName 病因的名字
     * @return 个数
     */
    @Query("match(c:Cause) where c.name=$causeName return COUNT(*)")
    long isExits(@Param("causeName") String causeName);

    /**
     * 插入病因
     *
     * @param causeName 病因的名字
     * @return 结果
     */
    @Query("CREATE (c:Cause) SET c.name= $causeName")
    void insertCause(@Param("causeName") String causeName);
}
