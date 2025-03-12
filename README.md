IOC（原理和概念）

1、什么是IOC（Inversion of Control）

（1）控制反转，把对象创建和对象之间的调用过程，交给Spring进行管理

（2）使用IOC目的：为了降低耦合度

2、IOC底层原理
（1）xml解析、工厂模式、反射

IOC（接口）

1、IOC思想基于IOC容器完成，IOC容器底层就是对象工厂

2、Spring提供IOC容器实现两种方式：（两个接口）

（1）BeanFactory：IOC容器基本实现，是Spring内部的使用接口，不提供给开发人员使用
                 加载配置文件时不会创建对象，在获取对象时才会创建

（2）ApplicationContext：BeanFactory接口的子接口，提供更多更强大的功能，供开发人员使用
                        加载配置文件时就会把在配置文件中的对象进行创建

3、ApplicationContext接口有实现类

IOC操作Bean管理

1、什么是Bean管理

Bean管理值的是两个操作：

（1）Spring创建对象

（2）Spring注入属性

2、Bean管理操作有两种方式

（1）基于xml配置文件方式实现

（2）基于注解方式实现

IOC操作Bean管理（基于xml方式）

1、基于xml方式创建对象

（1）在spring配置文件中，使用bean标签，标签里面添加对应属性，就可以实现对象创建

（2）bean标签常用属性介绍

1）id属性：唯一标识

2）class属性：类全路径（包类路径）

（3）创建对象的时候，默认执行无参构造方法完成对象创建

2、基于xml方式注入属性

（1）DI（Dependency Injection）：依赖注入，就是注入属性

第一种注入方式：使用set方法进行注入

第二种注入方式：使用有参构造进行注入

IOC操作Bean管理（xml注入其他类型属性）

1、字面量

（1）null值

（2）属性值包含特殊符号

2、注入属性-外部bean

3、注入属性-内部bean和级联赋值

（1）一对多关系

IOC操作Bean管理（xml注入集合类型属性）

1、注入数组类型属性

2、注入List集合类型属性

3、注入Map集合类型属性

4、在集合里面设置对象类型值

IOC操作Bean管理（FactoryBean）

1、Spring有两种类型bean，一种普通bean，另外一种工厂bean（FactoryBean）

2、普通bean：配置文件中class属性值就是bean标签的返回类型

3、工厂bean：配置文件中class属性值和bean标签的返回类型不一样

（1）创建类，让这个类作为工厂bean，实现接口FactoryBean

（2）实现接口里的方法，在实现的方法中定义返回的bean类型

IOC操作Bean管理（bean作用域）

1、在Spring里面，设置创建bean实例是单实例还是多实例

2、在Spring里面，默认情况下，bean是单实例对象

3、如何设置单实例还是多实例

（1）在spring配置文件bean标签里面有属性（scope）用于设置单实例还是多实例

（2）scope属性值

1）默认值：singleton，表示是单实例对象

2）prototype：表示是多实例对象

（3）singleton和prototype区别

1）singleton单实例，prototype多实例

2）设置scope值为singleton，加载spring配置文件的时候就会创建单实例对象
   设置scope值为prototype，加载spring配置文件的时候不会创建单实例对象，在调用getBean方法时创建多实例对象

IOC操作Bean管理（bean生命周期）

1、生命周期

从对象创建到对象销毁的过程

2、bean声明周期

（1）通过构造器创建bean实例（无参数构造）

（2）为bean的属性设置值和对其他bean引用（调用set方法）

（3）调用bean的初始化方法（需要配置初始化方法）

（4）bean可以被获取

（5）当容器关闭时，调用bean的销毁方法（需要配置销毁方法）

4、bean的后置处理器，bean生命周期有七步

（1）通过构造器创建bean实例（无参数构造）

（2）为bean的属性设置值和对其他bean引用（调用set方法）

（3）把bean实例传递bean后置处理器方法postProcessBeforeInitialization

（4）调用bean的初始化方法（需要配置初始化方法）

（5）把bean实例传递bean后置处理器方法postProcessAfterInitialization

（6）bean可以被获取

（7）当容器关闭时，调用bean的销毁方法（需要配置销毁方法）

5、实现后置处理器

（1）创建类，实现接口BeanProcessor，创建后置处理器

IOC操作Bean管理（xml自动装配）

1、什么是自动装配

根据指定装配规则（属性名称或者属性类型），Spring自动将匹配的属性值进行注入

IOC操作Bean管理（外部属性文件）

1、直接配置数据库信息

（1）配置德鲁伊连接池

（2）引入德鲁伊连接池依赖jar包

2、引入外部属性文件配置数据库连接池

（1）创建外部属性文件，properties格式文件

（2）把外部properties属性文件引入到spring配置文件中

引入context名称空间

IOC操作Bean管理（基于注解方式）

1、什么是注解

（1）注解是代码特殊标记，格式：@属性名称(属性名称=属性值, 属性名称=属性值...)

（2）注解作用在类上面，方法上面，属性上面

（3）使用注解的目的：简化xml配置

2、Spring针对Bean管理中创建对象提供注解

（1）Component

（2）Service

（3）Controller

（4）Repository

上面四个注解功能是一样的，都可以用来创建bean实例

3、基于注解方式实现对象创建

第一步，引入依赖

第二步：开启组件扫描

第三步：创建类，在类上面添加创建对象注解

4、基于注解方式实现属性注入

（1）@Autowired：根据属性类型进行自动注入

（2）@Qualifier：根据属性名称进行自动注入，需要和@Autowired一起使用

（3）@Resource：可以根据属性类型进行自动注入，也可以根据属性名称进行自动注入

（4）@Value：注入普通类型属性

5、完全注解开发

创建配置类，替代xml配置文件

AOP（Aspect Oriented Programming）概念
1、什么是AOP
（1）面向切面（方面）编程，利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率

（2）通俗讲：就是在不修改源代码的前提下，在主干功能里面添加新功能

AOP（底层原理）

1、AOP底层使用动态代理

（1）有两种情况动态代理

第一种：有接口情况，使用JDK动态代理

创建接口实现类代理对象，增强类的方法

第二种：没有接口情况，使用CGLIB动态代理

创建子类的代理对象，增强类的方法

AOP（JDK动态代理）

1、使用JDK动态代理，使用Proxy类里面的方法创建代理对象

satic Object newProxyInstance(ClassLoader loader, 类<?>[] interfaces, InvocationHandler h)返回指定接口的代理类的实例，该接口将方法调用分派给指定的调用处理程序

方法有三个参数：

第一个参数：类加载器

第二个参数：增强方法所在的类，这个类实现的接口，支持多个接口

第三个参数：实现这个接口InvocationHandler，创建代理对象，写增强的方法

2、编写JDK动态代理代码

（1）创建接口，定义方法

（2）创建接口实现类，实现方法

（3）使用Proxy类创建接口代理对象

AOP（术语）

1、连接点：类里面哪些方法可以被增强

2、切入点：实际被增强的方法

3、通知（增强）：

（1）实际增强的逻辑部分称为通知，也就是增加的业务逻辑

（2）通知有多种类型：前置通知、后置通知、环绕通知、异常通知、最终通知

4、切面：把通知应用到切入点的过程，是一个动作

AOP操作（准备）
1、Spring框架一般都是基于AspectJ实现AOP操作

什么是AspectJ：AspectJ不是Spring组成部分，独立AOP框架，一般把AspectJ和Spring框架一起使用，进行AOP操作

2、基于AspectJ实现AOP操作

（1）基于AspectJ实现AOP操作

（2）基于注解方式实现

4、切入点表达式

（1）切入点表达式作用：知道对哪个类里面的哪个方法进行增强

（2）语法结构：execution([权限修饰符]([返回值类型])[类全路径][方法名称]([参数列表]))

举例1：对com.atguigu.dao.BookDao类里面的add进行增强：execution(* com.atguigu.dao.BookDao.add(..))

举例2：对com.atguigu.dao.BookDao类里面的所有方法进行增强：execution(* com.atguigu.dao.BookDao.*(..))

举例3：对com.atguigu.dao包里面所有类，类里面所有方法进行增强：execution(* com.atguigu.dao.*.*(..))

AOP操作（AspectJ注解）

1、创建类，在类里面定义方法

2、创建增强类，在增强类里面，创建方法，让不同方法代表不同通知类型

3、进行通知的配置

（1）在spring配置文件中，开启注解扫描

（2）使用注解创建User和UserProxy对象

（3）在增强类上面添加注解@Aspect

（4）在spring配置文件中开启生成代理对象

4、配置不同类型的通知：在增强类的里面，在通知方法上面添加通知类型注解，使用切入点表达式配置

5、相同切入点抽取

6、有多个增强类对用一个方法进行增强，设置增强类优先级：在增强类上添加@Order(数字类型值)注解，数值类型值越小优先级越高

AOP操作（AspectJ配置文件）

1、创建两个类，增强类和被增强类，创建方法

2、在spring配置文件中创建两个类对象

3、在spring配置文件中配置切入点


