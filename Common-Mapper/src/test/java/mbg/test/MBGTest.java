package mbg.test;

import mbg.entities.Employee;
import mbg.mappers.EmployeeMapper;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import java.io.InputStream;
import java.util.List;

/**
 * @author lhang
 * @create 2020-07-28 17:55
 */
public class MBGTest {
    public static void main(String[] args) {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = MBGTest.class.getClassLoader().getResourceAsStream("generator/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //***********************
        //按照Java方式整合通用Mapper的特殊设置
        //i.创建MapperHelper对象
        MapperHelper mapperHelper = new MapperHelper();

        //ii.通过MapperHelper对象对MyBatis原生的Configuration对象进行处理
        Configuration configuration = sqlSession.getConfiguration();
        mapperHelper.processConfiguration(configuration);

        //***********************
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employees = employeeMapper.selectAll();
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }
}
