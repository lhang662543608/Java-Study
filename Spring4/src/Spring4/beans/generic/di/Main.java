package Spring4.beans.generic.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhang
 * @create 2020-07-07 16:09
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-generic-di.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.add();
    }
}
