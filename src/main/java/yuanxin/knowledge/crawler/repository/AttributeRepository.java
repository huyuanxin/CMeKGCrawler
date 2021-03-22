package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ztt
 */
@Repository
public interface AttributeRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化Attribute,设置Attribute的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (a:Attribute) ASSERT a.name IS UNIQUE")
    void initAttribute();

    /**
     * 插入属性
     *
     * @param attributeName 属性名称
     */
    @Query("CREATE (a:Attribute) SET a.name= $attributeName")
    void insertAttribute(@Param("attributeName") String attributeName);

    /**
     * 返回特定名称属性的数量,作为是否存在的判断
     * * @param attributeName 属性名称
     *
     * @return 存在的数量
     */
    @Query("match(a:Attribute) where a.name= $attributeName return COUNT(*)")
    long isExits(@Param("attributeName") String attributeName);
}

