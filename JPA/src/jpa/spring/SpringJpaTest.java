package jpa.spring;

import jpa.service.CustomerService;
import jpa.service.PersonService;
import jpa.spring.entities.Customer;
import jpa.spring.entities.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author lhang
 * @create 2020-07-17 17:19
 */
public class SpringJpaTest {

    private ApplicationContext ctx = null;
    private PersonService personService = null;
    private CustomerService customerService = null;



    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        personService = ctx.getBean(PersonService.class);
        customerService = ctx.getBean(CustomerService.class);

    }

    @Test
    public void testRemoveCustomer() {
        customerService.removeCustomer(2);
    }

    @Test
    public void testFindCustomer() {
        Customer customer = customerService.findCustomer(1);
        System.out.println("customer = " + customer);
    }

    @Test
    public void testPersistCustomer() {
        Customer customer = new Customer();
        customer.setLastName("Jack");
        customer.setAge(18);
        customer.setBirth(new java.util.Date());
        customer.setCreateTime(new java.util.Date());
        customer.setEmail("Jack@163.com");
//        customer.setId(100);  //JPA不支持为主键赋值，会抛出异常

        customerService.persistCustomer(customer);

        System.out.println(customer.getId());
    }

    @Test
    public void testPersonService() {
        Person person1 = new Person();
        person1.setLastName("Jack");
        person1.setAge(18);
        person1.setEmail("Jack@163.com");

        Person person2 = new Person();
        person2.setLastName("Rose");
        person2.setAge(19);
        person2.setEmail("Rose@163.com");

        personService.persistPersons(person1, person2);

    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }



}
