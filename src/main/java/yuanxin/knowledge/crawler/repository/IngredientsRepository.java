package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 药物-成份
 * @author ztt
 */
@Repository
public interface IngredientsRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化Ingredients,设置Ingredients的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (i:Ingredients) ASSERT i.name IS UNIQUE")
    void initIngredients();

    /**
     * 插入成份
     *
     * @param ingredientsName 成份名称
     */
    @Query("CREATE (i:Ingredients) SET i.name= $ingredientsName")
    void insertIngredients(@Param("ingredientsName") String ingredientsName);

    /**
     * 返回特定名称成份的数量,作为是否存在的判断
     * @param ingredientsName 成份名称
     * @return 存在的数量
     */
    @Query("match(i:Ingredients) where i.name= $ingredientsName return COUNT(*)")
    long isExits(@Param("ingredientsName") String ingredientsName);
}
