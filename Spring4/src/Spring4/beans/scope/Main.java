package Spring4.beans.scope;

import Spring4.beans.autowire.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhang
 * @create 2020-07-06 17:46
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-scope.xml");

        Car car = (Car) ctx.getBean("car");
        System.out.println("car = " + car);

        Car car2 = (Car) ctx.getBean("car");
        System.out.println("car2 = " + car2);

        System.out.println(car==car2);
    }
}
