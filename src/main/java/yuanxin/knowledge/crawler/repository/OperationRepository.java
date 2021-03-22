package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * @author ztt
 */
@Repository
public interface OperationRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化Operation,设置Operation的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (o:Operation) ASSERT o.name IS UNIQUE")
    void initOperation();

    /**
     * 插入手术治疗
     *
     * @param operationTherapyName 手术治疗名称
     */
    @Query("CREATE (o:Operation) SET o.name= $operationTherapyName")
    void insertOperation(@Param("operationTherapyName") String operationTherapyName);

    /**
     * 返回特定名称手术治疗的数量,作为是否存在的判断
     * * @param operationTherapyName 手术治疗名称
     *
     * @return 存在的数量
     */
    @Query("match(o:Operation) where o.name= $operationTherapyName return COUNT(*)")
    long isExits(@Param("operationTherapyName") String operationTherapyName);
}