package com.mi.service;

import com.mi.dao.PlayerDao;
import com.mi.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerDao playerDao;

    /**
     * 新增
     * @param player
     */
    public void addPlayer(Player player) {
        playerDao.add(player);
    }

    /**
     * 修改
     * @param player
     */
    public void updatePlayer(Player player) {
        playerDao.update(player);
    }

    /**
     * 删除
     * @param id
     */
    public void deletePlayer(Long id) {
        playerDao.delete(id);
    }

    /**
     * 查询表记录数
     * @return
     */
    public int findTotal() {
        return playerDao.selectTotal();
    }

    /**
     * 查询返回对象
     * @return
     */
    public Player findById(Long id) {
        return playerDao.selectById(id);
    }

    /**
     * 查询返回集合
     * @return
     */
    public List<Player> findAll() {
        return playerDao.selectAll();
    }

    /**
     * 批量添加
     */
    public int[] batchAdd(List<Object[]> batchArgs) {
        return playerDao.batchInsert(batchArgs);
    }

    /**
     * 批量修改
     */
    public int[] batchUpdate(List<Object[]> batchArgs) {
        return playerDao.batchUpdate(batchArgs);
    }

    /**
     * 批量删除
     */
    public int[] batchDelete(List<Object[]> batchArgs) {
        return playerDao.batchDelete(batchArgs);
    }
}
