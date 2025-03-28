package unit.spring;

import com.mi.spring.dao.UserDao2;
import com.mi.spring.dao.impl.UserDao2Impl;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJdkProxy {

    @Test
    public void test01() {
        UserDao2 userDao2 = new UserDao2Impl();

        // 创建代理对象
        UserDao2 proxy = (UserDao2) Proxy.newProxyInstance(UserDao2.class.getClassLoader(), new Class[]{UserDao2.class}, new UserDaoProxy(userDao2));

        int result = proxy.add(1, 2);
        System.out.println(result);
    }
}

// 创建代理对象代码
class UserDaoProxy implements InvocationHandler {

    // 1、把被代理的对象作为成员变量
    private Object object;

    // 2、通过构造方法给成员变量赋值
    public UserDaoProxy(Object object) {
        this.object = object;
    }

    // 增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 方法之前的处理逻辑
        System.out.println("======调用被代理类的业务逻辑======start");

        // 被增强的方法
        Object result = method.invoke(this.object, args);

        // 方法之后的处理逻辑
        System.out.println("======调用被代理类的业务逻辑======end");
        return result;
    }
}