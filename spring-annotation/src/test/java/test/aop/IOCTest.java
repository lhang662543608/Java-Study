package test.aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring4.aop.MathCalculator;
import spring4.config.aop.MainConfig;

/**
 * @author lhang
 * @create 2020-07-22 15:41
 */
public class IOCTest {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(24,2);


    }
}
