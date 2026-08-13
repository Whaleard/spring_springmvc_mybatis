package com.mi.spring.factorybean;

import com.mi.spring.entity.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * 在Spring框架中，Bean的创建通常由容器直接通过反射机制完成。
 * 然而，某些场景下对象的创建逻辑较为复杂（例如需要依赖外部资源、动态代理或定制化初始化流程），此时直接通过@Bean注解可能无法满足需求。
 * FactoryBean是Spring提供的一个强大接口，允许开发者通过编程方式控制Bean的创建过程。
 *
 * FactoryBean是Spring框架中的一个接口（位于org.springframework.beans.factory包），用于创建复杂对象。
 * 与普通Bean不同，它本身是一个“工厂”，负责生成另一个Bean的实例。
 *
 * FactoryBean是Spring中一种高级定制化机制，适用于复杂对象的创建场景。
 * 通过它，开发者可以灵活控制Bean的初始化过程，实现与第三方库的无缝集成。
 */
public class CustomBean implements FactoryBean<Course> {

    /**
     * 定义返回bean
     * @return
     * @throws Exception
     */
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setName("java");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
