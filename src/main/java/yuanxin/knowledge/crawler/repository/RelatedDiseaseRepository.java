package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface RelatedDiseaseRepository extends Neo4jRepository<Object, Integer> {
    /**
     * 初始化相关疾病
     */
    @Query("CREATE CONSTRAINT ON (c:RelatedDisease) ASSERT c.name IS UNIQUE")
    void initRelatedDisease();

    /**
     * 查询指定名字的相关疾病的个数
     *
     * @param relatedDiseaseName 相关疾病的名字
     * @return 个数
     */
    @Query("match(r:RelatedDisease) where r.name=$relatedDiseaseName return COUNT(*)")
    long isExits(@Param("relatedDiseaseName") String relatedDiseaseName);

    /**
     * 插入相关疾病
     *
     * @param relatedDiseaseName 相关疾病的名字
     * @return 结果
     */
    @Query("CREATE (r:RelatedDisease) SET r.name= $relatedDiseaseName")
    void insertRelatedDisease(@Param("relatedDiseaseName") String relatedDiseaseName);
}
