package com.mi.spring.service;

import com.mi.spring.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 在Spring框架中，如果使用了多个数据源或多个数据库环境，并且希望对这些环境分别使用不同的事务管理器，
 * 可以通过@Transactional注解的value属性（或者在Spring 4.1及以后版本中使用transactionManager属性）来指定具体使用哪个事务管理器。
 */
@Service
@Transactional(value = "transactionManager", rollbackFor = Exception.class)
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
