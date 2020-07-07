package Spring4.beans.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhang
 * @create 2020-07-06 10:42
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        User user3 = ctx.getBean("user3",User.class);
        System.out.println("user3 = " + user3);

        Person person = ctx.getBean("person", Person.class);
        System.out.println("person = " + person);

        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println("dataSource = " + dataSource);

        User user4 = ctx.getBean("user4", User.class);
        System.out.println("user4 = " + user4);
    }
}
