package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * 药物-不良反应
 * @author ztt
 */
@Repository
public interface AdverseReactionsRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化AdverseReactions,设置AdverseReactions的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (a:AdverseReactions) ASSERT a.name IS UNIQUE")
    void initAdverseReactions();

    /**
     * 插入AdverseReactions
     *
     * @param adverseReactionsName 不良反应名称
     */
    @Query("CREATE (a:AdverseReactions) SET a.name= $adverseReactionsName")
    void insertAdverseReactions(@Param("adverseReactionsName") String adverseReactionsName);

    /**
     * 返回特定名称不良反应的数量,作为是否存在的判断
     * @param adverseReactionsName 不良反应名称
     * @return 存在的数量
     */
    @Query("match(a:AdverseReactions) where a.name= $adverseReactionsName return COUNT(*)")
    long isExits(@Param("adverseReactionsName") String adverseReactionsName);
}

