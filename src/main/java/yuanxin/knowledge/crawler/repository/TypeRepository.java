package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface TypeRepository extends Neo4jRepository<Object, Integer> {
    /**
     * 初始化Type,设置Type的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (t:Type) ASSERT t.name IS UNIQUE")
    void initType();

    /**
     * 插入分类
     *
     * @param typeName 分类名称
     */
    @Query("CREATE (t:Type) SET t.name= $typeName")
    void insertType(@Param("typeName") String typeName);

    /**
     * 返回特点名称分类的数量,作为是否存在的判断
     *
     * @param typeName 分类名称
     * @return 存在的数量
     */
    @Query("match(t:Type) where t.name=$typeName return COUNT(*)")
    long isExits(@Param("typeName") String typeName);
}
