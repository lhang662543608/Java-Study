package mapper_extends.mappers;


import mapper_extends.entities.Employee;
import mapper_extends.mine_mappers.MyMapper;
import org.apache.ibatis.annotations.CacheNamespace;

/**
 * @author lhang
 * @create 2020-07-28 19:24
 */
@CacheNamespace
public interface EmployeeMapper extends MyMapper<Employee> {
}
