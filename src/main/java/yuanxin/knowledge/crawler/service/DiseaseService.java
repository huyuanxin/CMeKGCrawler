package yuanxin.knowledge.crawler.service;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


/**
 * @author huyuanxin
 */
@Service
public interface DiseaseService extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化Disease,设置Disease的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (d:Disease) ASSERT d.name IS UNIQUE")
    void initDisease();

    /**
     * 插入疾病
     *
     * @param diseaseName 疾病名称
     */
    @Query("CREATE (d:Disease) SET d.name= $diseaseName")
    void insertDisease(@Param("diseaseName") String diseaseName);

    /**
     * 返回特点名称疾病的数量,作为是否存在的判断
     * * @param diseaseName 疾病名称
     *
     * @return 存在的数量
     */
    @Query("match(d:Disease) where d.name=$diseaseName return COUNT(*)")
    long exists(@Param("diseaseName") String diseaseName);
}
