package ssm.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.crud.bean.Department;
import ssm.crud.dao.DepartmentMapper;

import java.util.List;

/**
 * @author lhang
 * @create 2020-08-06 16:55
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;


    public List<Department> getDepts() {
        //查出的所有部门的信息
        List<Department> departments = departmentMapper.selectByExample(null);
        return departments;
    }
}
