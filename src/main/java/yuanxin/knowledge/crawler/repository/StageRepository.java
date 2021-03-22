package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * 症状-阶段
 * @author ztt
 */
@Repository
public interface StageRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化Stage,设置Stage的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (s:Stage) ASSERT s.name IS UNIQUE")
    void initStage();

    /**
     * 插入阶段
     *
     * @param StageName 阶段名称
     */
    @Query("CREATE (s:Stage) SET s.name= $StageName")
    void insertStage(@Param("StageName") String StageName);

    /**
     * 返回特定名称阶段的数量,作为是否存在的判断
     * * @param StageName 阶段名称
     *
     * @return 存在的数量
     */
    @Query("match(s:Stage) where s.name= $StageName return COUNT(*)")
    long isExits(@Param("StageName") String StageName);
}
