package ssm.crud.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.crud.bean.Employee;
import ssm.crud.dao.DepartmentMapper;
import ssm.crud.dao.EmployeeMapper;

import java.util.List;

/**
 * 测试dao层
 *
 * @author lhang
 * @create 2020-08-04 19:18
 * <p>
 * 推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 * 1、导入SpringTest模块
 * 2、@ContextConfiguration指定Spring配置文件的位置
 * 3、直接autowired要使用的组件即可
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;


    /**
     * 测试departmentMapper
     */
    @Test
    public void testCRUD() {
        System.out.println(departmentMapper);
        //1.插入几个部门
        /*departmentMapper.insertSelective(new Department(null, "开发部"));
        departmentMapper.insertSelective(new Department(null, "测试部"));*/

        //2.生成员工数据，测试员工插入
        //employeeMapper.insertSelective(new Employee(null, "Jerry", "M", "Jerry@atguigu.com", 1));

        //3、批量插入多个员工；批量，使用可以执行批量操作的sqlSession。

//		for(){
//			employeeMapper.insertSelective(new Employee(null, , "M", "Jerry@163.com", 1));
//		}

        /*EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
            mapper.insertSelective(new Employee(null, uid, "M", uid + "@163.com", (Math.random()>0.5?1:0)+1));
        }
        System.out.println("批量完成");*/

        List<Employee> employees = employeeMapper.selectByExampleWithDept(null);
        employees.forEach(System.out::println);



    }
}
