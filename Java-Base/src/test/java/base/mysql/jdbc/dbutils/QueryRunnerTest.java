package base.mysql.jdbc.dbutils;

import base.mysql.jdbc.JDBCUtils;
import base.mysql.jdbc.bean.User;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;



/*
 * commons-dbutils 是 Apache 组织提供的一个开源 JDBC工具类库,封装了针对于数据库的增删改查操作
 * 
 */
public class QueryRunnerTest {
	
	//测试插入
	@Test
	public void testInsert() {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection3();
			String sql = "insert into user_table(username,password,balance)values(?,?,?)";
			int insertCount = runner.update(conn, sql, "Rose","qqqqq",300);
			System.out.println("添加了" + insertCount + "条记录");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			JDBCUtils.closeResource(conn, null);
		}
		
	}
	
	//测试查询
	/*
	 * BeanHander:是ResultSetHandler接口的实现类，用于封装表中的一条记录。
	 */
	@Test
	public void testQuery1(){
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection3();
			String sql = "select username,password,balance from user_table where username = ?";
			BeanHandler<User> handler = new BeanHandler<>(User.class);
			User user = runner.query(conn, sql, handler, "Jack");
			System.out.println(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
			
		}
		
	}
	
	/*
	 * BeanListHandler:是ResultSetHandler接口的实现类，用于封装表中的多条记录构成的集合。
	 */
	@Test
	public void testQuery2() {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection3();
			String sql = "select username,password,balance from user_table";
			
			BeanListHandler<User>  handler = new BeanListHandler<>(User.class);

			List<User> list = runner.query(conn, sql, handler);
			list.forEach(System.out::println);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			JDBCUtils.closeResource(conn, null);
		}
		
	}
	
	/*
	 * MapHander:是ResultSetHandler接口的实现类，对应表中的一条记录。
	 * 将字段及相应字段的值作为map中的key和value
	 */
	@Test
	public void testQuery3(){
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection3();
			String sql = "select username,password,balance from user_table where username = ?";
			MapHandler handler = new MapHandler();
			Map<String, Object> map = runner.query(conn, sql, handler, "Jack");
			System.out.println(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
			
		}
		
	}
	
	/*
	 * MapListHander:是ResultSetHandler接口的实现类，对应表中的多条记录。
	 * 将字段及相应字段的值作为map中的key和value。将这些map添加到List中
	 */
	@Test
	public void testQuery4(){
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection3();
			String sql = "select username,password,balance from user_table";
		
			MapListHandler handler = new MapListHandler();
			List<Map<String, Object>> list = runner.query(conn, sql, handler);
			list.forEach(System.out::println);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
			
		}
		
	}
	/*
	 * ScalarHandler:用于查询特殊值
	 */
	@Test
	public void testQuery5(){
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection3();
			
			String sql = "select count(*) from user_table";
			
			ScalarHandler handler = new ScalarHandler();
			
			Long count = (Long) runner.query(conn, sql, handler);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
			
		}
		
	}
	@Test
	public void testQuery6(){
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection3();
			
			String sql = "select max(balance) from user_table";
			
			ScalarHandler handler = new ScalarHandler();
			BigDecimal maxBalance = (BigDecimal) runner.query(conn, sql, handler);
			System.out.println("maxBalance = " + maxBalance);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
			
		}
		
	}
	
	/*
	 * 自定义ResultSetHandler的实现类
	 */
	@Test
	public void testQuery7(){
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection3();
			
			String sql = "select username,password,balance from user_table where username = ?";
			ResultSetHandler<User> handler = new ResultSetHandler<User>(){

				@Override
				public User handle(ResultSet rs) throws SQLException {
//					System.out.println("handle");
//					return null;
					
//					return new Customer(12, "成龙", "Jacky@126.com", new Date(234324234324L));
					
					if(rs.next()){
						String username = rs.getString("username");
						String password = rs.getString("password");
						BigDecimal balance = rs.getBigDecimal("balance");
						User user = new User(username,password,balance);
						return user;
					}
					return null;
					
				}
				
			};
			User user = runner.query(conn, sql, handler,"Jack");
			System.out.println("user = " + user);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
			
		}
		
	}
	
}
