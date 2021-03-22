package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface InfectiousRepository extends Neo4jRepository<Object, Integer> {
    /**
     * 初始化传染性
     */
    @Query("CREATE CONSTRAINT ON (c:Infectious) ASSERT c.name IS UNIQUE")
    void initInfectious();

    /**
     * 查询指定名字的传染性的个数
     *
     * @param infectiousName 传染性的名字
     * @return 个数
     */
    @Query("match(c:Infectious) where c.name=$infectiousName return COUNT(*)")
    long isExits(@Param("infectiousName") String infectiousName);

    /**
     * 插入传染性
     *
     * @param infectiousName 传染性的名字
     * @return 结果
     */
    @Query("CREATE (c:Infectious) SET c.name= $infectiousName")
    void insertInfectious(@Param("infectiousName") String infectiousName);
}
