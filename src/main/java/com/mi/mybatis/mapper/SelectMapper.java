package com.mi.mybatis.mapper;

import com.mi.mybatis.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    /**
     * 根据id查询用户信息（返回值为实体对象）
     * @param id
     * @return
     */
    User getUserById(@Param("id") Long id);

    /**
     * 查询所有用户信息（返回值为list集合，集合元素为实体类对象）
     * @return
     */
    List<User> getAllUser();

    /**
     * 查询用户总数
     * @return
     */
    Integer getCount();

    /**
     * 根据id查询用户信息（返回值为map集合）
     * @param id
     * @return
     */
    Map<String, Object> getUserByIdToMap(@Param("id") Long id);

    /**
     * 查询所有用户信息（返回值为list集合，集合元素为map集合）
     * @return
     */
    List<Map<String, Object>> getAllUserToListOfMap();

    /**
     * 查询所有用户信息（返回值为map集合）
     * @return
     */
    @MapKey("id")
    Map<String, Object> getAllUserToMap();
}
