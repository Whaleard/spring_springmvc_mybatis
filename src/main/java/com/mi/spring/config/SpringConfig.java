package com.mi.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Spring初始化Bean规则：
 *  在Spring框架中，当使用@Configuration注解标注一个类时，Spring容器会认为这个类是用来定义bean的。
 *  当在这个类中通过@Bean注解标注的方法时，这些方法会被Spring容器识别为工厂方法，用于生成bean实例。
 *  Spring容器启动时‌默认会初始化@Bean定义的单例Bean‌，但若配置了‌懒加载（@Lazy）‌或Bean作用域为‌非单例（如 prototype）‌，则不会在启动时初始化。
 *
 * @Configuration：定义配置类，代替xml配置文件
 * @ComponentScan：开启注解扫描
 * @EnableAspectJAutoProxy：开启AspectJ生成代理对象，实现AOP功能
 * @EnableTransactionManagement：开启事务
 */
@Configuration
@ComponentScan(basePackages = {"com.mi.spring"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
public class SpringConfig {

    /**
     * Spring配置类中@Bean方法定义的Bean名称命名规则
     *  未指定名称时，Bean名称默认等于方法名。
     *  指定名称时，@Bean(name = "xxx")或@Bean("xxx")，Bean名称等于指定字符串；若传多个值，第一个为住名称，其余为别名。
     *
     * 创建数据库连接池
     * @return
     */
    @Bean
    public DruidDataSource getDruidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/userdb");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    /**
     * 被@Bean修饰的方法入参自动注入，是因为Spring在解析配置类时，将方法参数视为‌依赖点‌，默认按‌@Autowired规则（先按类型、再按名称/@Primary）‌从容器中查找并装配对应Bean。
     *
     * 创建JdbcTemplate对象
     * @param dataSource
     * @return
     */
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 注入dataSource
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
