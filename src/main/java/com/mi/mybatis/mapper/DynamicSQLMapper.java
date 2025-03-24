package com.mi.mybatis.mapper;

import com.mi.mybatis.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {

    /**
     * 多条件查询（where标签）
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 多条件查询（trim标签）
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition2(Emp emp);

    /**
     * 多条件查询（choose、when、otherwise标签）
     * @param emp
     * @return
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 通过数组实现批量删除
     * @param eids
     * @return
     */
    int batchDeleteByArray(@Param("eids") Long[] eids);

    /**
     * 通过list集合实现批量添加
     * @param emps
     * @return
     */
    int batchInsertByList(@Param("emps") List<Emp> emps);
}
