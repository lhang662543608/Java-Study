package mapper_of_mine.mappers;


import mapper_of_mine.entities.Employee;
import mapper_of_mine.mine_mappers.MyMapper;

/**
 * 具体操作数据库的Mapper接口，需要继承通用Mapper提供的核心接口：Mapper<Employee>
 * 泛型类型就是实体类的类型
 *
 * @author lhang
 * @create 2020-07-27 10:31
 */
public interface EmployeeMapper extends MyMapper<Employee> {
}
