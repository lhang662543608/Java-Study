package _05_data_jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lhang
 * @create 2020-08-16 11:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataJdbcMainApplicationTest {
    @Autowired
    DataSource dataSource;

    @Test
    public void testDAtaSource() throws SQLException {
        //class org.apache.tomcat.jdbc.pool.DataSource
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}