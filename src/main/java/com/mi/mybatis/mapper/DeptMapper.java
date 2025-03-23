package com.mi.mybatis.mapper;

import com.mi.mybatis.entity.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /**
     * 通过分布查询查询员工以及员工对应的部门信息
     * 分步查询第二步：通过部门id查询员工所对应的部门
     * @param did
     * @return
     */
    Dept getEmpAndDeptByStepLast(@Param("did") Long did);

    /**
     * 获取部门以及部门中所有员工信息
     * @param did
     * @return
     */
    Dept getDeptAndEmp(@Param("did") Long did);

    /**
     * 通过分布查询查询部门以及部门中所有的员工信息
     * 分步查询第一步：查询部门信息
     * @param did
     * @return
     */
    Dept getDeptAndEmpByStepFirst(@Param("did") Long did);
}
