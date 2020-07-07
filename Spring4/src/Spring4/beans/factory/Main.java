package Spring4.beans.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhang
 * @create 2020-07-07 8:11
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-factory.xml");
        Car car1 = (Car) ctx.getBean("car1");
        System.out.println("car1 = " + car1);

        Car car2 = (Car) ctx.getBean("car2");
        System.out.println("car2 = " + car2);

    }
}
