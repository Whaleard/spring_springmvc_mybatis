package unit.mybatis;

import com.mi.mybatis.entity.Emp;
import com.mi.mybatis.mapper.EmpMapper;
import com.mi.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestResultMap {

    /*
        解决字段名和属性名不一致的情况：
            1、为字段起别名，保持和属性名一致
            2、设置全局配置，将下划线自动映射为驼峰：mapUnderscoreToCamelCase
            3、通过resultMap设置自定义的映射关系
     */

    /**
     * 通过resultType定义返回值
     */
    @Test
    public void test01() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        System.out.println(list);
    }

    /**
     * 通过resultMap定义返回值
     */
    @Test
    public void test02() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmpToResultMap();
        System.out.println(list);
    }

    /*
        处理多对一的映射关系：
            1、级联属性赋值
            2、association
            3、分步查询
     */

    @Test
    public void test03() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(5L);
        System.out.println(emp);
    }
}
