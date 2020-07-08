package Spring4.aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhang
 * @create 2020-07-08 10:35
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-annotation.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
        System.out.println(arithmeticCalculator.add(1, 2));
        System.out.println(arithmeticCalculator.div(8, 1));
    }
}
