package unit.mybatis;

import com.mi.mybatis.entity.Emp;
import com.mi.mybatis.mapper.DynamicSQLMapper;
import com.mi.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestDynamicSQL {

    /**
     * where标签
     */
    @Test
    public void test01() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, "苏小岑", 23, "女", "12345@qq.com"));
        System.out.println(list);
    }

    /**
     * trim标签
     */
    @Test
    public void test02() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition2(new Emp(null, "刘旭", 23, "男", "12345@qq.com"));
        System.out.println(list);
    }

    /**
     * choose标签
     */
    @Test
    public void test03() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByChoose(new Emp(9L, "曹佳", 23, "女", "12345@qq.com"));
        System.out.println(list);
        // 文件编码格式
        // System.out.println(System.getProperty("file.encoding"));
    }

    /**
     * foreach标签（循环数组）
     */
    @Test
    public void test04() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.batchDeleteByArray(new Long[]{15L, 16L});
        System.out.println(result);
    }

    /**
     * foreach标签（循环数组）
     */
    @Test
    public void test05() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "a", 23, "男", "123@qq.com");
        Emp emp2 = new Emp(null, "a", 23, "男", "123@qq.com");
        Emp emp3 = new Emp(null, "a", 23, "男", "123@qq.com");
        Emp emp4 = new Emp(null, "a", 23, "男", "123@qq.com");
        List<Emp> emps = Arrays.asList(emp, emp2, emp3, emp4);
        int result = mapper.batchInsertByList(emps);
        System.out.println(result);
    }

    /**
     * sql标签（sql片段）
     */
    @Test
    public void test06() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, "苏小岑", 23, "女", "12345@qq.com"));
        System.out.println(list);
    }
}
