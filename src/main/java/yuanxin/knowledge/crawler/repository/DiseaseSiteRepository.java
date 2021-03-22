package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface DiseaseSiteRepository extends Neo4jRepository<Object, Integer> {
    /**
     * 初始化发病部位
     */
    @Query("CREATE CONSTRAINT ON (c:DiseaseSite) ASSERT c.name IS UNIQUE")
    void initDiseaseSite();

    /**
     * 查询指定名字的发病部位的个数
     *
     * @param diseaseSiteName 发病部位的名字
     * @return 个数
     */
    @Query("match(c:DiseaseSite) where c.name=$diseaseSiteName return COUNT(*)")
    long isExits(@Param("diseaseSiteName") String diseaseSiteName);

    /**
     * 插入发病部位
     *
     * @param diseaseSiteName 发病部位的名字
     * @return 结果
     */
    @Query("CREATE (c:DiseaseSite) SET c.name= $diseaseSiteName")
    void insertDiseaseSite(@Param("diseaseSiteName") String diseaseSiteName);
}
