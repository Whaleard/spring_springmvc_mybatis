package com.mi.mybatis.mapper;

import com.mi.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {

    /**
     * 查询所有的用户信息
     * @return
     */
    List<User> getAllUser();

    /**
     * 根据用户名称查询用户信息
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 根据用户名密码查询用户信息
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username, String password);

    /**
     * 根据用户名密码查询用户信息（使用map封装）
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 根据用户名密码查询用户信息（使用@Param注解）
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
