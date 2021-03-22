package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface PrognosticSurvivalTimeRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化预后生存时间
     */
    @Query("CREATE CONSTRAINT ON (c:Cause) ASSERT c.name IS UNIQUE")
    void initPrognosticSurvivalTime();

    /**
     * 查询指定名字的预后生存时间的个数
     *
     * @param prognosticSurvivalTimeName 预后生存时间的名字
     * @return 个数
     */
    @Query("match(c:PrognosticSurvivalTime) where c.name=$prognosticSurvivalTimeName return COUNT(*)")
    long isExits(@Param("prognosticSurvivalTimeName") String prognosticSurvivalTimeName);

    /**
     * 插入预后生存时间
     *
     * @param prognosticSurvivalTimeName 预后生存时间的名字
     * @return 结果
     */
    @Query("CREATE (c:PrognosticSurvivalTime) SET c.name= $prognosticSurvivalTimeName")
    void insertPrognosticSurvivalTime(@Param("prognosticSurvivalTimeName") String prognosticSurvivalTimeName);
}
