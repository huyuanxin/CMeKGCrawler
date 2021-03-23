package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface CheckSubjectRepository extends Neo4jRepository<Object, Integer> {
    /**
     * 初始化检查科目
     */
    @Query("CREATE CONSTRAINT ON (c:CheckSubject) ASSERT c.name IS UNIQUE")
    void initCheckSubject();

    /**
     * 查询指定名字的检查科目的个数
     *
     * @param checkSubjectName 检查科目的名字
     * @return 个数
     */
    @Query("match(c:CheckSubject) where c.name=$checkSubjectName return COUNT(*)")
    long isExits(@Param("checkSubjectName") String checkSubjectName);

    /**
     * 插入检查科目
     *
     * @param checkSubjectName 检查科目的名字
     * @return 结果
     */
    @Query("CREATE (c:CheckSubject) SET c.name= $checkSubjectName")
    void insertCheckSubject(@Param("checkSubjectName") String checkSubjectName);
}
