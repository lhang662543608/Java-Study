package test.life_cycle;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring4.bean.Car;
import spring4.config.life_cycle.MainConfig;

/**
 * @author lhang
 * @create 2020-07-21 16:35
 */
public class IOCTest {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("容器创建完成。。。");
        Car car = applicationContext.getBean(Car.class);
//        System.out.println("car = " + car);
        applicationContext.close();
    }
}
