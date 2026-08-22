package unit.mybatis;

import com.mi.mybatis.entity.Emp;
import com.mi.mybatis.mapper.CacheMapper;
import com.mi.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis缓存查询的顺序
 *  1、先查询二级缓存，因为二级缓存中可能会有其他程序已经查出来的数据，可以拿来直接使用。
 *  2、如果二级缓存没有命中，再查询一级缓存。
 *  3、如果一级缓存也没有命中，则查询数据库。
 *  4、SqlSession关闭之后，一级缓存中的数据会写入二级缓存。
 */
public class TestCache {

    /**
     * 一级缓存是SqlSession级别的，通过同一个SqlSession查询的数据会被缓存，下次查询相同的数据，就会从缓存中直接获取，不会从数据库重新访问
     *  一级缓存失效的四种情况：
     *      1、不同的SqlSession对应不同的一级缓存
     *      2、同一个SqlSession但是查询条件不同
     *      3、同一个SqlSession两次查询期间执行了任何一次增删改操作
     *      4、同一个SqlSession两次查询期间手动清空了缓存
     */
    @Test
    public void test01() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp = mapper.getEmpById(5L);
        System.out.println(emp);
        System.out.println("==============================================================");
        // 手动清空缓存
        // sqlSession.clearCache();
        Emp emp2 = mapper.getEmpById(5L);
        System.out.println(emp2);
        System.out.println("==============================================================");
        CacheMapper mapper2 = sqlSession.getMapper(CacheMapper.class);
        Emp emp3 = mapper2.getEmpById(5L);
        System.out.println(emp3);
        System.out.println("==============================================================");
        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper3 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp4 = mapper3.getEmpById(5L);
        System.out.println(emp4);
    }

    /**
     * 二级缓存是SqlSessionFactory级别，通过同一个SqlSessionFactory创建的SqlSession查询的结果会被缓存，此后若再次执行相同的查询语句，结果就会从缓存中获取
     * 二级缓存开启的条件：
     *      1、在核心配置文件中，设置全局配置属性cacheEnable="true"，开启二级缓存
     *      2、在映射文件中设置标签<cache />
     *      3、二级缓存必须在SqlSession关闭或提交之后有效
     *      4、查询的数据所转换的实体类类型必须实现序列化接口
     *  二级缓存失效情况：
     *      两次查询之间执行了任意的增删改操作，会师一级和二级缓存同时失效
     */
    @Test
    public void test02() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
            Emp emp = mapper.getEmpById(5L);
            System.out.println(emp);
            // 关闭SqlSession
            sqlSession.close();
            System.out.println("==============================================================");
            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            Emp emp2 = mapper2.getEmpById(5L);
            System.out.println(emp2);
            sqlSession2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
