package com.mi.mybatis.mapper;

import com.mi.mybatis.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {

    /**
     * 查询所有的员工信息
     * @return
     */
    List<Employee> getAllEmployee();

    /**
     * 根据用户名称查询员工信息
     * @param username
     * @return
     */
    Employee getEmployeeByUsername(String username);

    /**
     * 根据用户名密码查询员工信息
     * @param username
     * @param password
     * @return
     */
    Employee checkLogin(String username, String password);

    /**
     * 根据用户名密码查询员工信息（使用map封装）
     * @param map
     * @return
     */
    Employee checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户信息
     * @param employee
     * @return
     */
    int insertEmployee(Employee employee);

    /**
     * 根据用户名密码查询员工信息（使用@Param注解）
     * @param username
     * @param password
     * @return
     */
    Employee checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
