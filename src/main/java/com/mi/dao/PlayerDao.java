package com.mi.dao;

import com.mi.entity.Player;

import java.util.List;

public interface PlayerDao {

    /**
     * 新增
     * @param player
     */
    void add(Player player);

    /**
     * 修改
     * @param player
     */
    void update(Player player);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 查询表记录数
     */
    Integer selectTotal();

    /**
     * 查询返回对象
     * @param id
     * @return
     */
    Player selectById(Long id);

    /**
     * 查询返回集合
     * @return
     */
    List<Player> selectAll();

    /**
     * 批量添加
     * @param batchArgs
     */
    int[] batchInsert(List<Object[]> batchArgs);

    /**
     * 批量修改
     * @param batchArgs
     * @return
     */
    int[] batchUpdate(List<Object[]> batchArgs);

    /**
     * 批量删除
     * @param batchArgs
     * @return
     */
    int[] batchDelete(List<Object[]> batchArgs);
}
