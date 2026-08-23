package unit.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mi.mybatis.entity.Emp;
import com.mi.mybatis.mapper.EmpMapper;
import com.mi.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestPageHelper {

    /**
     * limit index pageSize
     *  index：当前页的起始索引。index=(pageNum-1)*pageSize。
     *  pageSize：每页显示的记录数。
     *  pageNum：当前页的页码。
     *
     * 使用MyBatis的分页插件实现分页功能
     *  1、需要在查询功能之前开启分页。
     *  2、在查询功能之后获取分页相关信息。
     */
    @Test
    public void test01() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        // 开启分页
        PageHelper.startPage(1, 4);
        List<Emp> list = mapper.getAllEmp();
        // 获取分页信息
        PageInfo<Emp> pageInfo = new PageInfo<>(list, 5);
        System.out.println(pageInfo);
    }
}
