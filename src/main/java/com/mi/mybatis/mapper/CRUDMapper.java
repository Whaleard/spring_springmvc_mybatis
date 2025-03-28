package com.mi.mybatis.mapper;

import com.mi.mybatis.entity.User;

import java.util.List;

/**
 * Mybatis面向接口编程的两个一致：
 *      1、映射文件的namespace要和mapper接口的全类名保持一致
 *      2、映射文件中SQL语句的id要和mapper接口中的方法名一致
 */
public interface CRUDMapper {

    /**
     * 添加用户信息
     * @return
     */
    int insertUser();

    /**
     * 修改用户信息
     * @return
     */
    int updateUser();

    /**
     * 删除用户信息
     * @return
     */
    int deleteUser();

    /**
     * 根据id查询用户信息
     * @return
     */
    User getUserById();

    /**
     * 查询所有的用户信息
     * @return
     */
    List<User> getAllUser();
}
