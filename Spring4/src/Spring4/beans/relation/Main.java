package Spring4.beans.relation;

import Spring4.beans.autowire.Address;
import Spring4.beans.autowire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhang
 * @create 2020-07-06 16:54
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-relation.xml");
        Address address = (Address) ctx.getBean("address2");
        System.out.println("address = " + address);

        address = (Address) ctx.getBean("address3");
        System.out.println("address = " + address);

        Person person = (Person) ctx.getBean("person");
        System.out.println("person = " + person);
    }
}
