package unit.mybatis;

import com.mi.mybatis.entity.User;
import com.mi.mybatis.mapper.SelectMapper;
import com.mi.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/*
    Mybatis的各种查询功能：
        1、若查询出来的数据只有一条
            （1）通过实体类对象接收
            （2）通过list集合接收
            （3）通过map集合接收
        2、若查询出来的数据有多条
            （1）通过list集合接收，集合元素为实体类对象
            （2）通过list集合接收，集合元素为map集合
            （3）在mapper接口的方法上添加@MapKey注解，就可以将每条数据作为mmap集合的值，@MapKey注解中的字段对应的值作为键
            注意：一定不能通过实体类对象接收，此时会抛异常TooManyResultsException
    Mybatis中设置了默认的类型别名

 */
public class TestSelect {

    /**
     * 返回单个对象
     */
    @Test
    public void test01() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(5);
        System.out.println(user);
    }

    /**
     * 返回list集合，集合元素为实体类对象
     */
    @Test
    public void test02() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUser();
        System.out.println(list);
    }

    /**
     * 返回单个值
     */
    @Test
    public void test03() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer result = mapper.getCount();
        System.out.println(result);
    }

    /**
     * 返回map集合（单个实体类对象）
     */
    @Test
    public void test04() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> employee = mapper.getUserByIdToMap(5);
        System.out.println(employee);
    }

    /**
     * 返回list集合，集合元素为map集合
     */
    @Test
    public void test05() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> list = mapper.getAllUserToListOfMap();
        System.out.println(list);
    }

    /**
     * 返回map集合（多个实体类对象）
     */
    @Test
    public void test06() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getAllUserToMap();
        System.out.println(map);
    }
}
