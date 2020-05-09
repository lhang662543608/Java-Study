package base.mysql.jdbc.dao;

import base.mysql.jdbc.bean.User;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {


    @Override
    public void insert(Connection conn, User user) {
        String sql = "insert into user_table(username,password,balance)values(?,?,?)";
        update(conn, sql, user.getUsername(), user.getPassword(), user.getBalance());
    }

    @Override
    public void deleteByUsername(Connection conn, String username) {
        String sql = "delete from user_table where username = ?";
        update(conn, sql, username);
    }

    @Override
    public void update(Connection conn, User user) {
        String sql = "update user_table set password = ?,balance = ? where username = ?";
        update(conn, sql, user.getPassword(), user.getBalance(), user.getUsername());
    }

    @Override
    public User getUserByUsername(Connection conn, String  username) {
        String sql = "select username,password,balance from user_table where username = ?";
        User user = getInstance(conn, sql, username);
        return user;
    }

    @Override
    public List<User> getAll(Connection conn) {
        String sql = "select username,password,balance from user_table";
        List<User> list = getForList(conn, sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from user_table";
        return getValue(conn, sql);
    }

    @Override
    public BigDecimal getMaxBalance(Connection conn) {
        String sql = "select max(balance) from user_table";
        return getValue(conn, sql);
    }

}
