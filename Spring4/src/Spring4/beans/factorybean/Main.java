package Spring4.beans.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhang
 * @create 2020-07-07 8:55
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-factorybean.xml");
        Car car = (Car) ctx.getBean("car");
        System.out.println("car = " + car);
    }
}
