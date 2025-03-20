package com.mi.mybatis.mapper;

import com.mi.mybatis.entity.Employee;

import java.util.List;

/**
 * Mybatis面向接口编程的两个一致：
 *      1、映射文件的namespace要和mapper接口的全类名保持一致
 *      2、映射文件中SQL语句的id要和mapper接口中的方法名一致
 */
public interface CRUDMapper {

    /**
     * 添加员工信息
     * @return
     */
    int insertEmployee();

    /**
     * 修改员工信息
     * @return
     */
    int updateEmployee();

    /**
     * 删除员工信息
     * @return
     */
    int deleteEmployee();

    /**
     * 根据id查询员工信息
     * @return
     */
    Employee getEmployeeById();

    /**
     * 查询所有的员工信息
     * @return
     */
    List<Employee> getAllUser();
}
