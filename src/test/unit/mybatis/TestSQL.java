package unit.mybatis;

import com.mi.mybatis.entity.User;
import com.mi.mybatis.mapper.SQLMapper;
import com.mi.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestSQL {

    /**
     * 模糊查询
     */
    @Test
    public void test01() {
        // todo sqlsession和connection
        // todo sqlsessionutils.getsqlsession()和sqlsessionfactory.opensession()
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByName("张三");
        System.out.println(list);
    }

    /**
     * 批量删除
     */
    @Test
    public void test02() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int result = mapper.batchDelete("5,6,7");
        System.out.println(result);
    }

    /**
     * 动态查表
     */
    @Test
    public void test03() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByTableName("t_user");
        System.out.println(list);
    }

    /**
     * 返回主键
     */
    @Test
    public void test04() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null, "王五", "123456", 23, "男", "12345@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
