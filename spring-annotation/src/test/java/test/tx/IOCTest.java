package test.tx;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring4.config.tx.MainConfig;
import spring4.service.UserService;

/**
 * @author lhang
 * @create 2020-07-22 16:22
 */
public class IOCTest {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertUser();


        applicationContext.close();
    }
}
