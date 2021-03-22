package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface PathologicalTypeRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化病理分型
     */
    @Query("CREATE CONSTRAINT ON (c:PathologicalType) ASSERT c.name IS UNIQUE")
    void initPathologicalType();

    /**
     * 查询指定名字的病理分型的个数
     *
     * @param pathologicalTypeName 病理分型的名字
     * @return 个数
     */
    @Query("match(c:PathologicalType) where c.name=$pathologicalTypeName return COUNT(*)")
    long isExits(@Param("pathologicalTypeName") String pathologicalTypeName);

    /**
     * 插入病理分型
     *
     * @param pathologicalTypeName 病理分型的名字
     * @return 结果
     */
    @Query("CREATE (c:PathologicalType) SET c.name= $pathologicalTypeName")
    void insertPathologicalType(@Param("pathologicalTypeName") String pathologicalTypeName);

}
