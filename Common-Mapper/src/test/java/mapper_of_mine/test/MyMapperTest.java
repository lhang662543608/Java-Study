package mapper_of_mine.test;

import mapper_of_mine.entities.Employee;
import mapper_of_mine.services.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author lhang
 * @create 2020-07-28 18:48
 */
public class MyMapperTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("mapper_of_mine/spring-context.xml");

        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);

        List<Employee> employees = employeeService.getAll();
        employees.forEach(System.out::println);

        applicationContext.close();
    }
}
