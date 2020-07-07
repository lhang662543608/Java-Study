package Spring4.beans.annotation;

import Spring4.beans.annotation.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhang
 * @create 2020-07-07 9:24
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-annotation.xml");

        /*TestObject testObject = (TestObject) ctx.getBean("testObject");
        System.out.println("testObject = " + testObject);

        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println("userService = " + userService);

        UserRepository userRepository = (UserRepository) ctx.getBean("UserRepository");
        System.out.println("userRepository = " + userRepository);*/

        UserController userController = ctx.getBean(UserController.class);
//        System.out.println("userController = " + userController);
        userController.execute();
    }
}
