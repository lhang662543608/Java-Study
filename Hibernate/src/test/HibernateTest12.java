package test;

import entity.Department;
import entity.Employee;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;


public class HibernateTest12 {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    @After
    public void destroy() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testHQLUpdate() {
        String hql = "DELETE FROM Department d WHERE d.id = :id";

        session.createQuery(hql).setInteger("id", 280)
                .executeUpdate();
    }

    @Test
    public void testNativeSQL() {
        String sql = "INSERT INTO GG_DEPARTMENT VALUES(?, ?)";
        Query query = session.createSQLQuery(sql);

        query.setInteger(1, 4)
                .setString(2, "设计部")
                .executeUpdate();
    }

    @Test
    public void testQBC4() {
        Criteria criteria = session.createCriteria(Employee.class);

        //1. 添加排序
        criteria.addOrder(Order.asc("salary"));
        criteria.addOrder(Order.desc("email"));

        //2. 添加翻页方法
        int pageSize = 5;
        int pageNo = 3;
        criteria.setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
    }

    @Test
    public void testQBC3() {
        Criteria criteria = session.createCriteria(Employee.class);

        //统计查询: 使用 Projection 来表示: 可以由 Projections 的静态方法得到
        criteria.setProjection(Projections.max("salary"));

        System.out.println(criteria.uniqueResult());
    }

    @Test
    public void testQBC2() {
        Criteria criteria = session.createCriteria(Employee.class);

        //1. AND: 使用 Conjunction 表示
        //Conjunction 本身就是一个 Criterion 对象
        //且其中还可以添加 Criterion 对象
        Conjunction conjunction = Restrictions.conjunction();
        conjunction.add(Restrictions.like("name", "a", MatchMode.ANYWHERE));
        Department dept = new Department();
        dept.setId(80);
        conjunction.add(Restrictions.eq("dept", dept));
        System.out.println(conjunction);

        //2. OR
        Disjunction disjunction = Restrictions.disjunction();
        disjunction.add(Restrictions.ge("salary", 6000F));
        disjunction.add(Restrictions.isNull("email"));

        criteria.add(disjunction);
        criteria.add(conjunction);

        criteria.list();
    }

    @Test
    public void testQBC() {
        //1. 创建一个 Criteria 对象
        Criteria criteria = session.createCriteria(Employee.class);

        //2. 添加查询条件: 在 QBC 中查询条件使用 Criterion 来表示
        //Criterion 可以通过 Restrictions 的静态方法得到
        criteria.add(Restrictions.eq("email", "SKUMAR"));
        criteria.add(Restrictions.gt("salary", 5000F));

        //3. 执行查询
        Employee employee = (Employee) criteria.uniqueResult();
        System.out.println(employee);
    }

    @Test
    public void testLeftJoinFetch2() {
        String hql = "SELECT e FROM Employee e INNER JOIN e.dept";
        Query query = session.createQuery(hql);

        List<Employee> emps = query.list();
        System.out.println(emps.size());

        for (Employee emp : emps) {
            System.out.println(emp.getName() + ", " + emp.getDept().getName());
        }
    }

    @Test
    public void testLeftJoin() {
        String hql = "SELECT DISTINCT d FROM Department d LEFT JOIN d.emps";
        Query query = session.createQuery(hql);

        List<Department> depts = query.list();
        System.out.println(depts.size());

        for (Department dept : depts) {
            System.out.println(dept.getName() + ", " + dept.getEmps().size());
        }

//		List<Object []> result = query.list(); 
//		result = new ArrayList<>(new LinkedHashSet<>(result));
//		System.out.println(result); 
//		
//		for(Object [] objs: result){
//			System.out.println(Arrays.asList(objs));
//		}
    }

    @Test
    public void testLeftJoinFetch() {
//		String hql = "SELECT DISTINCT d FROM Department d LEFT JOIN FETCH d.emps";
        String hql = "FROM Department d INNER JOIN FETCH d.emps";
        Query query = session.createQuery(hql);

        List<Department> depts = query.list();
        depts = new ArrayList<>(new LinkedHashSet(depts));
        System.out.println(depts.size());

        for (Department dept : depts) {
            System.out.println(dept.getName() + "-" + dept.getEmps().size());
        }
    }

    @Test
    public void testGroupBy() {
        String hql = "SELECT min(e.salary), max(e.salary) "
                + "FROM Employee e "
                + "GROUP BY e.dept "
                + "HAVING min(salary) > :minSal";

        Query query = session.createQuery(hql)
                .setFloat("minSal", 5000);

        List<Object[]> result = query.list();
        for (Object[] objs : result) {
            System.out.println(Arrays.asList(objs));
        }
    }

    @Test
    public void testFieldQuery2() {
        String hql = "SELECT new Employee(e.email, e.salary, e.dept) "
                + "FROM Employee e "
                + "WHERE e.dept = :dept";
        Query query = session.createQuery(hql);

        Department dept = new Department();
        dept.setId(2);
        List<Employee> result = query.setEntity("dept", dept)
                .list();

        for (Employee emp : result) {
            System.out.println(emp.getId() + ", " + emp.getEmail()
                    + ", " + emp.getSalary() + ", " + emp.getDept());
        }
    }

    @Test
    public void testFieldQuery() {
        String hql = "SELECT e.email, e.salary, e.dept FROM Employee e WHERE e.dept = :dept";
        Query query = session.createQuery(hql);

        Department dept = new Department();
        dept.setId(2);
        List<Object[]> result = query.setEntity("dept", dept)
                .list();

        for (Object[] objs : result) {
            System.out.println(Arrays.asList(objs));
        }
    }

    @Test
    public void testNamedQuery() {
        Query query = session.getNamedQuery("salaryEmps");

        List<Employee> emps = query.setFloat("minSal", 5000)
                .setFloat("maxSal", 10000)
                .list();

        System.out.println(emps.size());
    }

    @Test
    public void testPageQuery() {
        String hql = "FROM Employee";
        Query query = session.createQuery(hql);

        int pageNo = 2;
        int pageSize = 2;

        List<Employee> emps = query.setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
        System.out.println(emps);
    }

    @Test
    public void testHQLNamedParameter() {

        //1. 创建 Query 对象
        //基于命名参数.
        String hql = "FROM Employee e WHERE e.salary > :sal AND e.email LIKE :email";
        Query query = session.createQuery(hql);

        //2. 绑定参数
        query.setFloat("sal", 7000)
                .setString("email", "%o%");

        //3. 执行查询
        List<Employee> emps = query.list();
        System.out.println(emps.size());
    }

    @Test
    public void testHQL() {

        //1. 创建 Query 对象
        //基于位置的参数.
        String hql = "FROM Employee e WHERE e.salary > ?1 AND e.email LIKE ?2 AND e.dept = ?3 "
                + "ORDER BY e.salary";
        Query query = session.createQuery(hql);

        //2. 绑定参数
        //Query 对象调用 setXxx 方法支持方法链的编程风格.
        Department dept = new Department();
        dept.setId(3);
        query.setFloat(1, 6000)
                .setString(2, "%o%")
                .setEntity(3, dept);

        //3. 执行查询
        List<Employee> emps = query.list();
        System.out.println(emps.size());
    }


}
