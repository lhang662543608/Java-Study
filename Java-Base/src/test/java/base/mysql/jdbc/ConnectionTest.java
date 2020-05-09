package base.mysql.jdbc;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {
    //方式一
    @Test
    public void testConnection1() {

        Driver driver = null;
        String url = null;
        Properties info = null;
        try {
            //1.获取 Driver的实现类的对象
            driver = new com.mysql.jdbc.Driver();

            //2.提供要连接的数据库
            url = "jdbc:mysql://192.168.3.4:3306/life";

            //3.提供用户名和密码
            info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "lhang");
            //4.获取连接
            Connection connect = driver.connect(url, info);
            System.out.println("connect = " + connect);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //方式二
    @Test
    public void testConnection2() {
        String url = null;
        Properties info = null;
        try {
            //1.获取 Driver的实现类的对象
            Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
            Driver driver = (Driver) clazz.newInstance();
            //2.提供要连接的数据库
            url = "jdbc:mysql://192.168.3.4:3306/life";
            //3.提供用户名和密码
            info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "lhang");
            //4.获取连接
            Connection connect = driver.connect(url, info);
            System.out.println("connect = " + connect);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //方式三
    @Test
    public void testConnection3() {
        String url = null;
        String user = null;
        String password = null;
        try {
            //1.获取 Driver的实现类的对象
            Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
            Driver driver = (Driver) clazz.newInstance();
            //注册驱动
            DriverManager.registerDriver(driver);
            //2.提供要连接的数据库
            url = "jdbc:mysql://192.168.3.4:3306/life";
            //3.提供用户名和密码
            user = "root";
            password = "lhang";
            //4.获取连接
            Connection connect = DriverManager.getConnection(url, user, password);
            System.out.println("connect = " + connect);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //方式四
    @Test
    public void testConnection4() {
        String url = null;
        String user = null;
        String password = null;
        try {
            //1.提供要连接的数据库
            url = "jdbc:mysql://192.168.3.4:3306/life";
            //2.提供用户名和密码
            user = "root";
            password = "lhang";

            //3.加载Driver
            Class.forName("com.mysql.jdbc.Driver");
            /*Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
            Driver driver = (Driver) clazz.newInstance();
            //注册驱动
            DriverManager.registerDriver(driver);*/

            //4.获取连接
            Connection connect = DriverManager.getConnection(url, user, password);
            System.out.println("connect = " + connect);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //方式五:最终，推荐
    @Test
    public void testConnection5() {
        Properties properties= null;
        String url = null;
        String user = null;
        String password = null;
        String driverClass = null;
        try {
            //1.读取配置文件中会的四个基本信息
            InputStream inputStream = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties = new Properties();
            properties.load(inputStream);

            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
             driverClass = properties.getProperty("driverClass");


            //3.加载Driver
            Class.forName(driverClass);


            //4.获取连接
            Connection connect = DriverManager.getConnection(url, user, password);
            System.out.println("connect = " + connect);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
