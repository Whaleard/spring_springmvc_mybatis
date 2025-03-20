package unit.mybatis;

import com.mi.mybatis.entity.Employee;
import com.mi.mybatis.mapper.CRUDMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
    SqlSession默认不自动提交事务
    若需要自动提交事务，可以使用SqlSessionFactory.openSession(true);
 */
public class TestCRUD {

    /**
     * 新增
     *
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 提交事务
        // sqlSession.commit();
        // 获取mapper接口对象
        // todo 底层使用代理模式
        CRUDMapper mapper = sqlSession.getMapper(CRUDMapper.class);
        int result = mapper.insertEmployee();
        System.out.println(result);
    }

    /**
     * 修改
     *
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CRUDMapper mapper = sqlSession.getMapper(CRUDMapper.class);
        int result = mapper.updateEmployee();
        System.out.println(result);
    }

    /**
     * 删除
     *
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CRUDMapper mapper = sqlSession.getMapper(CRUDMapper.class);
        int result = mapper.deleteEmployee();
        System.out.println(result);
    }

    /**
     * 返回单个实体
     *
     * @throws IOException
     */
    @Test
    public void test04() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CRUDMapper mapper = sqlSession.getMapper(CRUDMapper.class);
        Employee employee = mapper.getEmployeeById();
        System.out.println(employee);
    }

    /**
     * 返回集合
     *
     * @throws IOException
     */
    @Test
    public void test05() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CRUDMapper mapper = sqlSession.getMapper(CRUDMapper.class);
        List<Employee> list = mapper.getAllUser();
        System.out.println(list);
    }
}
