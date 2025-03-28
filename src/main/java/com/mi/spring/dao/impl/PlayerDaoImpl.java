package com.mi.spring.dao.impl;

import com.mi.spring.dao.PlayerDao;
import com.mi.spring.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDaoImpl implements PlayerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Player player) {
        String sql = "insert into t_player (name, status) values (?, ?)";
        Object[] args = {player.getName(), player.getStatus()};
        int result = jdbcTemplate.update(sql, args);
        System.out.println(result);
    }

    @Override
    public void update(Player player) {
        String sql = "update t_player set name = ?, status = ? where id = ?";
        Object[] args = {player.getName(), player.getStatus(), player.getId()};
        int result = jdbcTemplate.update(sql, args);
        System.out.println(result);
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from t_player where id = ?";
        Object[] args = {id};
        int result = jdbcTemplate.update(sql, args);
        System.out.println(result);
    }

    @Override
    public Integer selectTotal() {
        String sql = "select count(*) from t_player";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Player selectById(Long id) {
        String sql = "select * from t_player where id = ?";
        Object[] args = {id};
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Player.class), args);
    }

    @Override
    public List<Player> selectAll() {
        String sql = "select * from t_player";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Player.class));
    }

    @Override
    public int[] batchInsert(List<Object[]> batchArgs) {
        String sql = "insert into t_player (name, status) values (?, ?)";
        return jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    @Override
    public int[] batchUpdate(List<Object[]> batchArgs) {
        String sql = "update t_player set name = ?, status = ? where id = ?";
        return jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    @Override
    public int[] batchDelete(List<Object[]> batchArgs) {
        String sql = "delete from t_player where id = ?";
        return jdbcTemplate.batchUpdate(sql, batchArgs);
    }
}
