package Spring4.beans.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhang
 * @create 2020-07-06 21:03
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-spel.xml");
        Address address = ctx.getBean(Address.class);
        System.out.println("address = " + address);

        Car car = ctx.getBean(Car.class);
        System.out.println("car = " + car);

        Person person = ctx.getBean(Person.class);
        System.out.println("person = " + person);
    }
}
