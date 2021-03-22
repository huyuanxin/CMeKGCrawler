package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface PrecautionsRepository extends Neo4jRepository<Object, Integer> {
    /**
     * 初始化Precautions,设置Precautions的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (t:Precautions) ASSERT t.name IS UNIQUE")
    void initPrecautions();

    /**
     * 插入注意事项
     *
     * @param precautionsName 名称
     */
    @Query("CREATE (t:Precautions) SET t.name= $precautionsName")
    void insertPrecautions(@Param("precautionsName") String precautionsName);

    /**
     * 返回特点名称注意事项的数量,作为是否存在的判断
     *
     * @param precautionsName 注意事项名称
     * @return 存在的数量
     */
    @Query("match(t:Precautions) where t.name=$precautionsName return COUNT(*)")
    long isExits(@Param("precautionsName") String precautionsName);
}
