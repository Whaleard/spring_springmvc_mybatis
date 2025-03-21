package unit.mybatis;

import com.mi.mybatis.entity.User;
import com.mi.mybatis.mapper.ParameterMapper;
import com.mi.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Mybatis获取参数值的两种方式：${}和#{}
        ${}本质是字符串拼接
        #{}本质是占位符赋值

    Mybatis获取参数值的各种情况：
        1、mapper接口方法的参数为单个字面量类型
          可以通过${}和#{}以任意的参数名称获取参数值，但需要注意${}的单引号问题
        2、mapper接口方法的参数为多个字面量类型
          Mybatis会将这些参数放在一个map集合中，以两种方式进行存储
            （1）以arg0、arg1...为键，以参数值为值
            （2）以param1、param2...为键，以参数值为值
          只需要通过#{键名}和${键名}方式访问值即可，但需要注意${}的单引号问题
        3、mapper接口方法的参数为多个字面量类型，可以手动将这些参数封装在一个map中
          只需要通过#{键名}和${键名}方式访问值即可，但需要注意${}的单引号问题
        4、mapper接口方法的参数是实体类类型的参数
          只需要通过#{属性名}和${属性名}方式访问值即可，但需要注意${}的单引号问题
        5、使用@Param注解命名参数
            （1）以@Param注解的值为键，以参数值为值
            （2）以param1、param2...为键，以参数值为值
          只需要通过#{键名}和${键名}方式访问值即可，但需要注意${}的单引号问题
 */
public class TestParameter {

    /**
     * sql中没有入参
     */
    @Test
    public void test01() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        System.out.println(list);
    }

    /**
     * sql中有单个入参
     */
    @Test
    public void test02() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("张三");
        System.out.println(user);
    }

    /**
     * sql中有多个入参
     */
    @Test
    public void test03() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("张三", "123456");
        System.out.println(user);
    }

    /**
     * sql中有多个入参并封装成map
     */
    @Test
    public void test04() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "张三");
        map.put("password", "123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    /**
     * sql中有多个入参并封装成对象
     */
    @Test
    public void test05() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result = mapper.insertUser(new User(null, "李四", "123456", 23, "男", "12345@qq.com"));
        System.out.println(result);
    }

    /**
     * sql中有多个入参并使用@Param注解
     */
    @Test
    public void test06() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("张三", "123456");
        System.out.println(user);
    }
}
