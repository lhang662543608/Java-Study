package test.attribute_assignment;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import spring4.bean.Person;
import spring4.config.attribute_assignment.MainConfig;

/**
 * @author lhang
 * @create 2020-07-21 18:37
 */
public class IOCTest {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println("property(\"person.nickName\") = " + property);

        Person person = applicationContext.getBean(Person.class);
        System.out.println("person = " + person);
        applicationContext.close();
    }
}
