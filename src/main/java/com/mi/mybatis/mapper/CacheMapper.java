package com.mi.mybatis.mapper;

import com.mi.mybatis.entity.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {

    /**
     * 通过id获取员工信息
     * @param eid
     * @return
     */
    Emp getEmpById(@Param("eid") Long eid);
}
