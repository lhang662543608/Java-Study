package mapper_extends.test;

import mapper_extends.entities.Employee;
import mapper_extends.services.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CacheTest {

    public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mapper_extends/spring-context.xml");
		
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		List<Employee> empList = employeeService.getAll();
		for (Employee employee : empList) {
			System.out.println(employee);
		}
		
		empList = employeeService.getAll();
		for (Employee employee : empList) {
			System.out.println(employee);
		}
		
		context.close();
	}

}