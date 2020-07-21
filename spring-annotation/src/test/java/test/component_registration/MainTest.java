package test.component_registration;

import spring4.bean.Person;
import spring4.config.component_registration.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lhang
 * @create 2020-07-21 10:21
 */
public class MainTest {
    public static void main(String[] args) {

        /*
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Person person = ctx.getBean(Person.class);
        System.out.println("person = " + person);
        */

        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println("person = " + person);

        String[] names = context.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }

    }

}
