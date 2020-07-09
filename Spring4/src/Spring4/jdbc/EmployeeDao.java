package Spring4.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author lhang
 * @create 2020-07-08 21:35
 */

@Repository
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee get(Integer id){
        String sql = "SELECT id, NAME , email FROM employees WHERE id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, id);

        return employee;
    }
}

