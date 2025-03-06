package unit;

import com.mi.config.SpringConfig;
import com.mi.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanAnnotation {

    /**
     * spring基于注解方式配置对象创建
     */
    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean3.xml");

        StudentService studentService = context.getBean("studentService", StudentService.class);

        System.out.println(studentService);
        studentService.add();
    }

    /**
     * 完全注解开发
     * 通过注解使用配置类代替xml配置文件
     */
    @Test
    public void test02() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        StudentService studentService = context.getBean("studentService", StudentService.class);

        System.out.println(studentService);
        studentService.add();
    }
}
