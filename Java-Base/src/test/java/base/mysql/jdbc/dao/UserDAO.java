package base.mysql.jdbc.dao;


import base.mysql.jdbc.bean.User;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

/*
 * 此接口用于规范针对于user_table表的常用操作
 */
public interface UserDAO {
    /**
     * @param conn
     * @param user
     * @Description 将cust对象添加到数据库中
     */
    void insert(Connection conn, User user);

    /**
     * @param conn
     * @param username
     * @Description 针对指定的id，删除表中的一条记录
     * @author shkstart
     * @date 上午11:01:07
     */
    void deleteByUsername(Connection conn, String username);

    /**
     * @param conn
     * @param user
     * @Description 针对内存中的cust对象，去修改数据表中指定的记录
     */
    void update(Connection conn, User user);

    /**
     * @param conn
     * @param user
     * @Description 针对指定的id查询得到对应的Customer对象
     */
    User getUserByUsername(Connection conn, String username);

    /**
     * @param conn
     * @return
     * @Description 查询表中的所有记录构成的集合
     */
    List<User> getAll(Connection conn);

    /**
     * @param conn
     * @return
     * @Description 返回数据表中的数据的条目数
     */
    Long getCount(Connection conn);

    /**
     * @param conn
     * @return
     * @Description 返回数据表中最大的薪资
     */
    BigDecimal getMaxBalance(Connection conn);

}	
