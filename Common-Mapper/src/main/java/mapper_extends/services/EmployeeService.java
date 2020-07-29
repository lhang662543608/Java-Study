package mapper_extends.services;

import mapper_extends.entities.Employee;
import mapper_extends.mappers.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lhang
 * @create 2020-07-28 19:25
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getAll() {
        return employeeMapper.selectAll();
    }

    public void batchUpdateEmp(List<Employee> empList) {
        employeeMapper.batchUpdate(empList);
    }

}
