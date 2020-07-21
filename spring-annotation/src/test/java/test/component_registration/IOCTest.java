package test.component_registration;

import spring4.bean.Person;
import spring4.config.component_registration.MainConfig;
import spring4.config.component_registration.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @author lhang
 * @create 2020-07-21 10:45
 */
public class IOCTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);


    @Test
    public void testImport(){
        printBeans(applicationContext);
       /* Blue bean = applicationContext.getBean(Blue.class);
        System.out.println(bean);

        //工厂Bean获取的是调用getObject创建的对象
        Object bean2 = applicationContext.getBean("colorFactoryBean");
        Object bean3 = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean的类型："+bean2.getClass());
        System.out.println(bean2 == bean3);

        Object bean4 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean4.getClass());*/
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test03(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        Environment environment = applicationContext.getEnvironment();
        //动态获取环境变量的值；Windows 10
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String name : namesForType) {
            System.out.println(name);
        }

        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);

    }

    @SuppressWarnings(value = "resource")
    @Test
    public void test02() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        /*String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }*/
        System.out.println("IOC容器创建完成。。。");
        Object person1 = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");
        System.out.println(person1 == person2);

    }

    @SuppressWarnings(value = "resource")
    @Test
    public void test01() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
