package base.mysql.jdbc.dao;

import base.mysql.jdbc.bean.User;
import base.mysql.jdbc.util.JDBCUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

public class UserDAOImplTest {


    static {
        UserDAO userDAO = new UserDAOImpl();
    }

    @Test
    public void insert() throws Exception {
        UserDAO userDAO = new UserDAOImpl();
        Connection connection = JDBCUtils.getConnection();
        User user = new User("Tom", "123", BigDecimal.valueOf(1000));
        userDAO.insert(connection, user);
    }

    @Test
    public void deleteByUsername() throws Exception {
        UserDAO userDAO = new UserDAOImpl();
        Connection connection = JDBCUtils.getConnection();
        userDAO.deleteByUsername(connection, "Tom");
    }

    @Test
    public void update() throws Exception {
        UserDAO userDAO = new UserDAOImpl();
        Connection connection = JDBCUtils.getConnection();
        User user = new User("DD", "123", BigDecimal.valueOf(1000));
        userDAO.update(connection, user);
    }

    @Test
    public void getUserByUsername() throws Exception {
        UserDAO userDAO = new UserDAOImpl();
        Connection connection = JDBCUtils.getConnection();
        User user = userDAO.getUserByUsername(connection, "DD");
        System.out.println("user = " + user);
    }

    @Test
    public void getAll() throws Exception {
        UserDAO userDAO = new UserDAOImpl();
        Connection connection = JDBCUtils.getConnection();
        List<User> list = userDAO.getAll(connection);
        list.forEach(System.out::println);
    }

    @Test
    public void getCount() throws Exception {
        UserDAO userDAO = new UserDAOImpl();
        Connection connection = base.mysql.jdbc.JDBCUtils.getConnection1();
        Long count = userDAO.getCount(connection);
        System.out.println("count = " + count);
    }

    @Test
    public void getMaxBalance() throws Exception {
        UserDAO userDAO = new UserDAOImpl();
        Connection connection = JDBCUtils.getConnection();
        BigDecimal maxBalance = userDAO.getMaxBalance(connection);
        System.out.println("maxBalance = " + maxBalance);
    }

}