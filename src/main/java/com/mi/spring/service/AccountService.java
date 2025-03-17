package com.mi.spring.service;

import com.mi.spring.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    /**
     * 转账
     */
    public void accountMoney() {
        // 编程式事务管理======start======
        // try {
        //     // 第一步：开启事务
        //
        //     // 第二步：进行业务操作
        //     accountDao.reduceMoney();
        //
        //     // 模拟异常
        //     int i = 1 / 0;
        //
        //     accountDao.addMoney();
        //
        //     // 第三步：没有发生异常，提交事务
        // } catch (Exception e) {
        //     // 第四步：发生异常，回滚事务
        // }
        // 编程式事务管理======end======

        accountDao.reduceMoney();

        int i = 1 / 0;

        accountDao.addMoney();
    }
}
