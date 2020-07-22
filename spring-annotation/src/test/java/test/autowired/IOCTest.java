package test.autowired;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring4.bean.Boss;
import spring4.bean.Car;
import spring4.bean.Color;
import spring4.config.autowired.MainConfig;
import spring4.service.BookService;

/**
 * @author lhang
 * @create 2020-07-22 9:13
 */
public class IOCTest {


    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);

        /*BookDao bookDao = applicationContext.getBean("bookDao", BookDao.class);
        System.out.println(bookDao);*/

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);
        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);
        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);

    }
}
