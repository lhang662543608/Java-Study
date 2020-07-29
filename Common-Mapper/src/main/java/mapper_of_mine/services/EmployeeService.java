package mapper_of_mine.services;


import mapper_of_mine.entities.Employee;
import mapper_of_mine.mappers.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author lhang
 * @create 2020-07-27 10:36
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getAll() {
        return employeeMapper.selectAll();
    }
}
