package com.mi.mybatis.mapper;

import com.mi.mybatis.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /**
     * 查询所有员工信息（使用resultType定义返回值）
     * @return
     */
    List<Emp> getAllEmp();

    /**
     * 查询所有员工信息（使用resultMap定义返回值）
     * @return
     */
    List<Emp> getAllEmpToResultMap();

    /**
     * 查询员工以及员工所对应的部门信息
     * @param eid
     * @return
     */
    Emp getEmpAndDept(@Param("eid") Long eid);

    /**
     * 通过分布查询查询员工以及员工对应的部门信息
     * 分步查询第一步：查询员工信息
     * @param eid
     * @return
     */
    Emp getEmpAndDeptByStepFirst(@Param("eid") Long eid);

    /**
     * 通过分布查询查询部门以及部门中所有的员工信息
     * 分步查询第二步：根据部门id查询员工信息
     * @param did
     * @return
     */
    List<Emp> getDeptAndEmpByStepLast(@Param("did") Long did);
}
