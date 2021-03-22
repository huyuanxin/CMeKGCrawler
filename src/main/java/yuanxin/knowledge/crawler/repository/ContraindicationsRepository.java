package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface ContraindicationsRepository extends Neo4jRepository<Object, Integer> {
    /**
     * 初始化Contraindications,设置Contraindications的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (t:Contraindications) ASSERT t.name IS UNIQUE")
    void initContraindications();

    /**
     * 插入禁忌证
     *
     * @param contraindicationsName 名称
     */
    @Query("CREATE (t:Contraindications) SET t.name= $contraindicationsName")
    void insertContraindications(@Param("contraindicationsName") String contraindicationsName);

    /**
     * 返回特点名称禁忌证的数量,作为是否存在的判断
     *
     * @param contraindicationsName 禁忌证名称
     * @return 存在的数量
     */
    @Query("match(t:Contraindications) where t.name=$contraindicationsName return COUNT(*)")
    long isExits(@Param("contraindicationsName") String contraindicationsName);
}
