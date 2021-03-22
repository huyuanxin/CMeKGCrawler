package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * 症状-传播途径
 * @author ztt
 */
@Repository
public interface SpreadWayRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化SpreadWay,设置SpreadWay的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (s:SpreadWay) ASSERT s.name IS UNIQUE")
    void initSpreadWay();

    /**
     * 插入传播途径
     *
     * @param spreadWayName 传播途径名称
     */
    @Query("CREATE (s:SpreadWay) SET s.name= $spreadWayName")
    void insertSpreadWay(@Param("spreadWayName") String spreadWayName);

    /**
     * 返回特定名称传播途径的数量,作为是否存在的判断
     * @param spreadWayName 传播途径名称
     * @return 存在的数量
     */
    @Query("match(s:SpreadWay) where s.name= $spreadWayName return COUNT(*)")
    long isExits(@Param("spreadWayName") String spreadWayName);
}
