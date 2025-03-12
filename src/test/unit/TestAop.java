package unit;

import com.mi.aop.Book;
import com.mi.aop.User2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    /**
     * Spring之前的版本：
     *      1、Around（环绕通知）
     *      2、Before（前置通知）
     *      3、被增强方法
     *      4、Around（环绕通知）
     *      5、After（后置通知）
     *      6、AfterReturning（返回通知）或AfterThrowing（异常通知）
     * Spring现在的版本：
     *      1、Around（环绕通知）
     *      2、Before（前置通知）
     *      3、被增强方法
     *      4、AfterReturning（返回通知）或AfterThrowing（异常通知）
     *      5、After（后置通知）
     *      6、Around（环绕通知）
     *
     *  注：如果被增强的方法报错，则增强方法后的环绕通知不执行
     */
    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean4.xml");

        User2 user = context.getBean("user2", User2.class);

        user.add();
    }

    @Test
    public void test02() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean5.xml");

        Book book = context.getBean("book", Book.class);

        book.buy();
    }
}
