package _02_configuration;

import _02_configuration.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lhang
 * @create 2020-08-14 8:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigurationMainApplicationTest {
    @Autowired
    Person person;

    @Autowired
    ApplicationContext context;

    @Test
    public void testHelloService(){
        Boolean b = context.containsBean("helloService");
        System.out.println( b);
    }

    @Test
    public void test(){
        System.out.println("person = " + person);
    }
}