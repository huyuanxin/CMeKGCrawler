package yuanxin.knowledge.crawler.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends Neo4jRepository<Object, Integer> {
    /**
     * 初始化所属科室
     */
    @Query("CREATE CONSTRAINT ON (c:Department) ASSERT c.name IS UNIQUE")
    void initDepartment();

    /**
     * 查询指定名字的所属科室的个数
     *
     * @param departmentName 所属科室的名字
     * @return 个数
     */
    @Query("match(c:Department) where c.name=$departmentName return COUNT(*)")
    long isExits(@Param("departmentName") String departmentName);

    /**
     * 插入所属科室
     *
     * @param departmentName 所属科室的名字
     * @return 结果
     */
    @Query("CREATE (c:Department) SET c.name= $departmentName")
    void insertDepartment(@Param("departmentName") String departmentName);
}
