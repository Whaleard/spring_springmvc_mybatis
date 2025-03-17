package unit;

import com.mi.config.SpringConfig;
import com.mi.entity.Player;
import com.mi.service.AccountService;
import com.mi.service.PlayerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestJdbcTemplate {

    /**
     * 新增测试
     */
    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean6.xml");

        PlayerService service = context.getBean("playerService", PlayerService.class);

        Player player = new Player();
        player.setName("tom");
        player.setStatus("正常");
        service.addPlayer(player);
    }

    /**
     * 修改测试
     */
    @Test
    public void test02() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean6.xml");

        PlayerService service = context.getBean("playerService", PlayerService.class);

        Player player = new Player();
        player.setId(1L);
        player.setName("tom");
        player.setStatus("正常");
        service.updatePlayer(player);
    }

    /**
     * 删除测试
     */
    @Test
    public void test03() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean6.xml");

        PlayerService service = context.getBean("playerService", PlayerService.class);

        service.deletePlayer(1L);
    }

    /**
     * 查询表记录数测试
     */
    @Test
    public void test04() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean6.xml");

        PlayerService service = context.getBean("playerService", PlayerService.class);

        int total = service.findTotal();
        System.out.println("表中总共有" + total + "条数据");
    }

    /**
     * 查询返回对象测试
     */
    @Test
    public void test05() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean6.xml");

        PlayerService service = context.getBean("playerService", PlayerService.class);

        Player player = service.findById(2L);
        System.out.println(player);
    }

    /**
     * 查询返回集合测试
     */
    @Test
    public void test06() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean6.xml");

        PlayerService service = context.getBean("playerService", PlayerService.class);

        List<Player> list = service.findAll();
        System.out.println(list);
    }

    /**
     * 批量添加测试
     */
    @Test
    public void test07() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean6.xml");

        PlayerService service = context.getBean("playerService", PlayerService.class);

        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o = {"mark", "正常"};
        Object[] o2 = {"lucy", "异常"};
        Object[] o3 = {"jack", "冻结"};
        batchArgs.add(o);
        batchArgs.add(o2);
        batchArgs.add(o3);

        int[] result = service.batchAdd(batchArgs);
        for (int i = 1; i <= result.length; i++) {
            System.out.println("第" + i + "条数据插入" + (i > 0 ? "成功" : "失败"));
        }
    }

    /**
     * 批量修改测试
     */
    @Test
    public void test08() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean6.xml");

        PlayerService service = context.getBean("playerService", PlayerService.class);

        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o = {"mark", "冻结", 6L};
        Object[] o2 = {"jack", "正常", 8L};
        batchArgs.add(o);
        batchArgs.add(o2);

        int[] result = service.batchUpdate(batchArgs);
        for (int i = 1; i <= result.length; i++) {
            System.out.println("第" + i + "条数据更新" + (i > 0 ? "成功" : "失败"));
        }
    }

    /**
     * 批量删除测试
     */
    @Test
    public void test09() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean6.xml");

        PlayerService service = context.getBean("playerService", PlayerService.class);

        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o = {7L};
        Object[] o2 = {8L};
        batchArgs.add(o);
        batchArgs.add(o2);

        int[] result = service.batchDelete(batchArgs);
        for (int i = 1; i <= result.length; i++) {
            System.out.println("第" + i + "条数据删除" + (i > 0 ? "成功" : "失败"));
        }
    }

    /**
     * 事务-注解方式
     */
    @Test
    public void test10() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean6.xml");

        AccountService service = context.getBean("accountService", AccountService.class);

        service.accountMoney();
    }

    /**
     * 事务-xml配置文件方式
     */
    @Test
    public void test11() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean7.xml");

        AccountService service = context.getBean("accountService", AccountService.class);

        service.accountMoney();
    }

    /**
     * 事务-完全注解方式
     */
    @Test
    public void test12() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountService service = context.getBean("accountService", AccountService.class);

        service.accountMoney();
    }
}
