package com.mi.service;

import com.mi.dao.StudentDao;
import com.mi.dao.StudentDao2;
import com.mi.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * 在注解里面value属性值可以省略不写：默认值是类名称，首字母小写
 *
 * @author Mr MC
 */
@Service(value = "studentService")
public class StudentService {

    // 通过@Value注解给属性注入值
    @Value(value = "tom")
    private String name;

    /*
        注入属性
        @Quailifier必须搭配@Autowired一起使用
        在同一个接口有多个实现类的情况下，可以根据不同实现类的名称进行注入
     */
    @Autowired
    @Qualifier(value = "studentDaoImpl2")
    private StudentDao studentDao;

    /*
        根据类型进行注入
        @Resource：根据类型进行注入
        @Resource(name="xxx")：根据名称进行注入
     */
    @Resource
    private StudentDao2 studentDao2;

    public void add() {
        System.out.println("=================");
        System.out.println("service add......");
        studentDao.add();
        studentDao2.sub();
        System.out.println("name：" + name);
        System.out.println("=================");
    }
}
