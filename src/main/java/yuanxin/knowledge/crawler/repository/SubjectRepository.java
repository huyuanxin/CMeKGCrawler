package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface SubjectRepository extends Neo4jRepository<Object, Integer> {
    /**
     * 初始化Subject,设置Subject的name为唯一值
     */
    @Query("CREATE CONSTRAINT ON (t:Subject) ASSERT t.name IS UNIQUE")
    void initSubject();

    /**
     * 插入所属科目
     *
     * @param subjectName 名称
     */
    @Query("CREATE (t:Subject) SET t.name= $subjectName")
    void insertSubject(@Param("subjectName") String subjectName);

    /**
     * 返回特点名称所属科目的数量,作为是否存在的判断
     *
     * @param subjectName 所属科目名称
     * @return 存在的数量
     */
    @Query("match(s:Subject) where s.name=$subjectName return COUNT(*)")
    long isExits(@Param("subjectName") String subjectName);
}
