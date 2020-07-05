package test;

import entity.Department;
import entity.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class HibernateTest13 {

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
    public void testBatch() {
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                //通过 JDBC 原生的 API 进行操作, 效率最高, 速度最快!
            }
        });
    }


    @Test
    public void testQueryIterate() {
        Department dept = session.get(Department.class, 70);
        System.out.println(dept.getName());
        System.out.println(dept.getEmps().size());

        Query query = session.createQuery("FROM Employee e WHERE e.dept.id = 2");
//		List<Employee> emps = query.list();
//		System.out.println(emps.size()); 

        Iterator<Employee> empIt = query.iterate();
        while (empIt.hasNext()) {
            System.out.println(empIt.next().getName());
        }
    }

    @Test
    public void testUpdateTimeStampCache() {
        Query query = session.createQuery("FROM Employee");
        query.setCacheable(true);

        List<Employee> emps = query.list();
        System.out.println(emps.size());

        Employee employee = session.get(Employee.class, 100);
        employee.setSalary(30000);

        emps = query.list();
        System.out.println(emps.size());
    }

    @Test
    public void testQueryCache() {
        Query query = session.createQuery("FROM Employee");
        query.setCacheable(true);

        List<Employee> emps = query.list();
        System.out.println(emps.size());

        emps = query.list();
        System.out.println(emps.size());

        Criteria criteria = session.createCriteria(Employee.class);
        criteria.setCacheable(true);
    }

    @Test
    public void testCollectionSecondLevelCache() {
        Department dept = session.get(Department.class, 2);
        System.out.println(dept.getName());
        System.out.println(dept.getEmps().size());

        transaction.commit();
        session.close();

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Department dept2 = session.get(Department.class, 2);
        System.out.println(dept2.getName());
        System.out.println(dept2.getEmps().size());
    }

    @Test
    public void testHibernateSecondLevelCache() {
        Employee employee = session.get(Employee.class, 1);
        System.out.println(employee.getName());

        transaction.commit();
        session.close();

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Employee employee2 = session.get(Employee.class, 1);
        System.out.println(employee2.getName());
    }

}
