package Spring4.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhang
 * @create 2020-07-06 8:57
 */
public class Main {
    public static void main(String[] args) {
//        HelloWorld helloWorld = new HelloWorld();
//        helloWorld.setName("Tom");


        /**
         * 1.创建Spring的IOC容器
         *   1)调用Helloworld的构造器，生成helloWorld对象
         *   2)调用setName方法设置helloWorld对象的属性
         */
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        /**
         * 2.从IOC容器中获取bean实例
         *
         */
        HelloWorld helloWorld = ctx.getBean("helloWorld",HelloWorld.class);
//        System.out.println(helloWorld);
        /**
         * 3.调用hello方法
         *
         */
//        helloWorld.hello();


        Car car = ctx.getBean(Car.class);
        System.out.println("car = " + car);

        User user = ctx.getBean("user", User.class);
        System.out.println("user = " + user);

        User user2 = ctx.getBean("user2", User.class);
        System.out.println("user2 = " + user2);


    }
}
