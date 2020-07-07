package Spring4.beans.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhang
 * @create 2020-07-06 21:43
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cycle.xml");
        Car car = ctx.getBean(Car.class);
        System.out.println("car = " + car);

        //关闭IOC容器
        ctx.close();
    }
}
