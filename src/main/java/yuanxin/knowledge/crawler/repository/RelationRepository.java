package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author huyuanxin
 */
public interface RelationRepository extends Neo4jRepository<Object, Integer> {
    /**
     * 插入并发症
     *
     * @param diseaseName      疾病名
     * @param complicationName 并发症名
     */
    @Query("MATCH (D:Disease) WHERE D.name=$diseaseName CREATE (D)-[r:并发症]->(C:Complication{name:$complicationName}) ")
    void insertResComplication(@Param("diseaseName") String diseaseName, @Param("complicationName") String complicationName);


}
