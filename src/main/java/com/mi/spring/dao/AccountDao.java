package com.mi.spring.dao;

public interface AccountDao {

    /**
     * 资金转入
     */
    void addMoney();

    /**
     * 资金转出
     */
    void reduceMoney();
}
