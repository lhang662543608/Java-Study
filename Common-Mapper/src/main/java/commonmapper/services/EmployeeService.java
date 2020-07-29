package commonmapper.services;


import commonmapper.entities.Employee;
import commonmapper.mappers.EmployeeMapper;
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


    public Employee getOne(Employee employee) {
        return employeeMapper.selectOne(employee);
    }

    public Employee getEmployeeById(Integer empId) {
        return employeeMapper.selectByPrimaryKey(empId);
    }

    public boolean isExists(Integer empId) {
        return employeeMapper.existsWithPrimaryKey(empId);
    }

    public void saveEmployee(Employee employee) {
        employeeMapper.insert(employee);
    }

    public void saveEmployeeSelective(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    public void updateEmployeeSelective(Employee employee) {

        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public void removeEmployee(Employee employee) {
        employeeMapper.delete(employee);
    }

    public void removeEmployeeById(Integer empId) {
        employeeMapper.deleteByPrimaryKey(empId);
    }

    public List<Employee> getEmpListByExample(Example example) {
        List<Employee> employees = employeeMapper.selectByExample(example);
        return employees;
    }


}
