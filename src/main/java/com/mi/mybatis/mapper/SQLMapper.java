package com.mi.mybatis.mapper;

import com.mi.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SQLMapper {

    /**
     * 根据用户名模糊查询用户信息
     * @param username
     * @return
     */
    List<User> getUserByName(@Param("username") String username);

    /**
     * 批量删除用户信息
     * @param ids
     * @return
     */
    int batchDelete(@Param("ids") String ids);

    /**
     * 查询用户表中数据
     * @param tableName
     * @return
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    int insertUser(User user);
}
