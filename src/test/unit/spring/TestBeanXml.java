package unit.spring;

import com.mi.spring.autowire.Emp3;
import com.mi.spring.entity.*;
import com.mi.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanXml {

    /**
     * spring基于xml方式通过bean标签配置对象创建
     */
    @Test
    public void test01() {
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        // 2、获取配置中创建的对象
        User user = context.getBean("user", User.class);

        System.out.println(user);
        user.add();
    }

    /**
     * spring基于xml方式通过bean标签配置对象创建并通过set方法注入属性
     */
    @Test
    public void test02() {
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        // 2、获取配置创建的对象
        Book book = context.getBean("book", Book.class);

        System.out.println(book);
        book.print();
    }

    /**
     * spring基于xml方式通过bean标签配置对象创建并通过有参构造方法注入属性
     */
    @Test
    public void test03() {
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        // 2、获取配置创建的对象
        Order order = context.getBean("order", Order.class);

        System.out.println(order);
        order.print();
    }

    /**
     * spring基于xml方式通过bean标签配置对象创建并通过p名称空间注入
     */
    @Test
    public void test04() {
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        // 2、获取配置创建的对象
        Book2 book2 = context.getBean("book2", Book2.class);

        System.out.println(book2);
        book2.print();
    }

    /**
     * spring基于xml方式通过bean标签配置对象创建并注入对象类型属性
     */
    @Test
    public void test05() {
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        // 2、获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);

        System.out.println(userService);
        userService.add();
    }

    /**
     * spring基于xml方式通过bean标签配置对象创建并注入内部bean对象
     */
    @Test
    public void test06() {
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        // 2、获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);

        System.out.println(emp);
        emp.print();
    }

    /**
     * spring基于xml方式通过bean标签配置对象创建并级联赋值
     */
    @Test
    public void test07() {
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        // 2、获取配置创建的对象
        Emp2 emp2 = context.getBean("emp2", Emp2.class);

        System.out.println(emp2);
        emp2.print();
    }

    /**
     * spring基于xml方式通过bean标签配置对象创建并注入集合类型属性
     */
    @Test
    public void test08() {
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        // 2、获取配置创建的对象
        Student student = context.getBean("student", Student.class);

        System.out.println(student);
        student.print();
    }

    /**
     * spring基于xml方式通过bean标签配置对象创建并注入集合类型属性，集合泛型为对象类型
     */
    @Test
    public void test09() {
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        // 2、获取配置创建的对象
        Student student = context.getBean("student", Student.class);

        System.out.println(student);
        student.print();
    }

    /**
     * spring基于xml方式通过bean标签配置对象创建并提取集合类型属性进行注入
     */
    @Test
    public void test10() {
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        // 2、获取配置创建的对象
        Book3 book3 = context.getBean("book3", Book3.class);

        System.out.println(book3);
        book3.print();
    }

    /**
     * spring基于xml方式通过bean标签配置工厂bean实现对象创建
     */
    @Test
    public void test11() {
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        // 2、获取配置创建的对象
        Course course = context.getBean("customBean", Course.class);

        System.out.println(course);
    }

    /**
     * spring通过IOC容器获取的对象默认情况下都是单例的
     */
    @Test
    public void test12() {
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        // 2、获取配置创建的对象
        Book book = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);

        System.out.println("=================");
        System.out.println(book);
        System.out.println(book2);
        System.out.println(book == book2);
        System.out.println("=================");
    }

    /**
     * spring基于xml方式通过bean标签配置对象创建并将对象设置为多实例对象
     */
    @Test
    public void test13() {
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        // 2、获取配置创建的对象
        Book4 book4 = context.getBean("book4", Book4.class);
        Book4 book4_2 = context.getBean("book4", Book4.class);

        System.out.println("=================");
        System.out.println(book4);
        System.out.println(book4_2);
        System.out.println(book4 == book4_2);
        System.out.println("=================");
    }

    /**
     * spring基于xml方式通过bean标签配置对象创建并查看对象生命周期
     */
    @Test
    public void test14() {
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        // 2、获取配置创建的对象
        Order2 order2 = context.getBean("order2", Order2.class);
        System.out.println("第六步，获取创建bean实例对象");
        System.out.println(order2);

        // 手动销毁bean实例
        ((ClassPathXmlApplicationContext) context).close();
    }

    /**
     * spring基于xml方式通过bean标签配置对象创建并配置后置处理器
     */
    @Test
    public void test15() {
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        // 2、获取配置创建的对象
        Order2 order2 = context.getBean("order2", Order2.class);
        System.out.println("第六步，获取创建bean实例对象");
        System.out.println(order2);

        // 手动销毁bean实例
        ((ClassPathXmlApplicationContext) context).close();
    }

    /**
     * spring基于xml方式通过bean标签配置对象创建并配置后置处理器
     */
    @Test
    public void test16() {
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        // 2、获取配置创建的对象
        Order2 order2 = context.getBean("order2", Order2.class);
        System.out.println("第六步，获取创建bean实例对象");
        System.out.println(order2);

        // 手动销毁bean实例
        ((ClassPathXmlApplicationContext) context).close();
    }

    /**
     * spring基于xml方式通过bean标签配置对象创建并自动装配
     */
    @Test
    public void test17() {
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean2.xml");

        // 2、获取配置创建的对象
        Emp3 emp3 = context.getBean("emp3", Emp3.class);

        System.out.println(emp3);
    }
}
