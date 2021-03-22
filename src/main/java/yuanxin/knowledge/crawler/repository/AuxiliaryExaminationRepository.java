package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * 症状-辅助检查
 * @author ztt
 */
@Repository
public interface AuxiliaryExaminationRepository extends Neo4jRepository<Object, Integer> {

    /**
     * 初始化AuxiliaryExamination,设置AuxiliaryExamination的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (a:AuxiliaryExamination) ASSERT a.name IS UNIQUE")
    void initAuxiliaryExamination();

    /**
     * 插入辅助检查
     *
     * @param auxiliaryExaminationName 辅助检查名称
     */
    @Query("CREATE (a:AuxiliaryExamination) SET a.name= $auxiliaryExaminationName")
    void insertAuxiliaryExamination(@Param("auxiliaryExaminationName") String auxiliaryExaminationName);

    /**
     * 返回特定名称辅助检查的数量,作为是否存在的判断
     * * @param auxiliaryExaminationName 辅助检查名称
     *
     * @return 存在的数量
     */
    @Query("match(a:AuxiliaryExamination) where a.name= $auxiliaryExaminationName return COUNT(*)")
    long isExits(@Param("auxiliaryExaminationName") String auxiliaryExaminationName);
}