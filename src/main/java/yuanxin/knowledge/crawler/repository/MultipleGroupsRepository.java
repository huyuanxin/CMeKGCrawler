package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface MultipleGroupsRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化多发群体
     */
    @Query("CREATE CONSTRAINT ON (c:MultipleGroups) ASSERT c.name IS UNIQUE")
    void initMultipleGroups();

    /**
     * 查询指定名字的多发群体的个数
     *
     * @param multipleGroupsName 多发群体的名字
     * @return 个数
     */
    @Query("match(c:MultipleGroups) where c.name=$multipleGroupsName return COUNT(*)")
    long isExits(@Param("multipleGroupsName") String multipleGroupsName);

    /**
     * 插入多发群体
     *
     * @param multipleGroupsName 多发群体的名字
     * @return 结果
     */
    @Query("CREATE (c:MultipleGroups) SET c.name= $multipleGroupsName")
    void insertMultipleGroups(@Param("multipleGroupsName") String multipleGroupsName);
}
