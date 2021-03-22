package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface CheckRepository extends Neo4jRepository<Object, Integer> {
    /**
     * 初始化检查
     */
    @Query("CREATE CONSTRAINT ON (c:Check) ASSERT c.name IS UNIQUE")
    void initCheck();

    /**
     * 查询指定名字的检查的个数
     *
     * @param checkName 检查的名字
     * @return 个数
     */
    @Query("match(c:Check) where c.name=$checkName return COUNT(*)")
    long isExits(@Param("checkName") String checkName);

    /**
     * 插入检查
     *
     * @param checkName 检查的名字
     * @return 结果
     */
    @Query("CREATE (c:Check) SET c.name= $checkName")
    void insertCheck(@Param("checkName") String checkName);
}
