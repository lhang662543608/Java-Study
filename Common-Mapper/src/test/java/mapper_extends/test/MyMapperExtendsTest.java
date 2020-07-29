package mapper_extends.test;

import mapper_extends.entities.Employee;
import mapper_extends.services.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhang
 * @create 2020-07-28 19:48
 */
public class MyMapperExtendsTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mapper_extends/spring-context.xml");
        EmployeeService employeeService = context.getBean(EmployeeService.class);

        List<Employee> empList = new ArrayList<>();

        empList.add(new Employee(7, "newName01", 111.11, 10));
        empList.add(new Employee(8, "newName02", 222.22, 20));
        empList.add(new Employee(9, "newName03", 333.33, 30));

        employeeService.batchUpdateEmp(empList);

        context.close();
    }
}
