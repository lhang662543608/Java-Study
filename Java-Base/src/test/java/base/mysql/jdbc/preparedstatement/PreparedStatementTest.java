package base.mysql.jdbc.preparedstatement;

import base.mysql.jdbc.bean.User;
import base.mysql.jdbc.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Properties;

/**
 * 使用PreparedStatement来替换Statement，实现对数据表的增删改操作。
 * <p>
 * 增删改查
 */
public class PreparedStatementTest {

    ///********************增删改***********************************///

    /**
     * 添加user_table表中的一条记录
     */
    @Test
    public void test() {
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try {
            //1.读取配置文件
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(inputStream);

            String user = properties.getProperty("user");
            String url = properties.getProperty("url");
            String password = properties.getProperty("password");
            String driverClass = properties.getProperty("driverClass");

            //2.加载驱动
            Class.forName(driverClass);

            //3.获取连接
            connection = DriverManager.getConnection(url, user, password);

            //4.预编译sql语句
            String sql = "INSERT INTO user_table(user,password) VALUES (?,?)";
            preparedStatement = connection.prepareStatement(sql);

            //5.填充占位符
            preparedStatement.setString(1, "ee");
            preparedStatement.setString(2, "ff");

            //6.执行操作
            preparedStatement.execute();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.资源关闭
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 使用封装JDBCUtils修改user_table表的一条记录
     */
    @Test
    public void testUpdate() {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            //1.获取连接
            connection = JDBCUtils.getConnection();

            //2.预编译sql语句
            String sql = "UPDATE  user_table SET `password`=? WHERE `user`=?";
            preparedStatement = connection.prepareStatement(sql);

            //3.填充占位符
            preparedStatement.setString(1, "cc");
            preparedStatement.setString(2, "cc");

            //4.执行操作
            preparedStatement.execute();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            JDBCUtils.closeResource(connection, preparedStatement);
        }
    }

    /**
     * 通用的增删改操作
     */
    public void update(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1.获取数据库连接
            connection = JDBCUtils.getConnection();
            //2.预编译SQL语句，返回PreparedStatement对象
            preparedStatement = connection.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            //4.执行
            preparedStatement.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.资源关闭
            JDBCUtils.closeResource(connection, preparedStatement);
        }
    }

    @Test
    public void testCommonUpdate() {
        /*String sql = "delete from user_table where user = ?";
        update(sql,"ee");*/

        String sql = "UPDATE  user_table SET `password`=? WHERE `user`=?";
        update(sql, "ee", "dd");
    }


    ///*****************查*****************************************///

    @Test
    public void testQueryForUser() {
        String sql = "select `user`,`password` from user_table where `user` =?";
        User user = queryForUser(sql, "dd");
        System.out.println("user = " + user);
    }

    public User queryForUser(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            //获取resultSet的元数据
            ResultSetMetaData rsmd = resultSet.getMetaData();
            //通过结果集的列数
            int count = rsmd.getColumnCount();
            if (resultSet.next()) {
                User user = new User();
                //处理结果集每一行的每一列
                for (int i = 0; i < count; i++) {
                    //获取列值
                    Object columnValue = resultSet.getObject(i + 1);
                    //获取列名
                    String columnName = rsmd.getColumnName(i + 1);
                    //给user对象指定column属性，赋值为column，通过反射
                    Field field = User.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(user, columnValue);
                }

                return user;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, preparedStatement, resultSet);
        }

        return null;
    }
}
