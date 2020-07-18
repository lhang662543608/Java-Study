package jpa.spring;

import jpa.spring.entities.Customer;
import jpa.spring.entities.Order;
import org.hibernate.ejb.QueryHints;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * @author lhang
 * @create 2020-07-17 21:49
 */

public class TestJPQL {
    private ApplicationContext ctx = null;
    private EntityManagerFactory entityManagerFactory = null;
    private EntityManager entityManager = null;
    private EntityTransaction transaction = null;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        entityManagerFactory = (EntityManagerFactory) ctx.getBean("entityManagerFactory");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    @Before
    public void before() {
        transaction.begin();
    }

    @After
    public void after() {
        transaction.commit();
    }

    //可以使用 JPQL 完成 UPDATE 和 DELETE 操作.
    @Test
    public void testExecuteUpdate() {
        String jpql = "UPDATE Customer c SET c.lastName = ? WHERE c.id = ?";
        Query query = entityManager.createQuery(jpql).setParameter(1, "YYY").setParameter(2, 2);

        query.executeUpdate();
    }

    //使用 jpql 内建的函数
    @Test
    public void testJpqlFunction() {
        String jpql = "SELECT lower(c.email) FROM Customer c";

        List<String> emails = entityManager.createQuery(jpql).getResultList();
        System.out.println(emails);
    }

    @Test
    public void testSubQuery() {
        //查询所有 Customer 的 lastName 为 YY 的 Order
        String jpql = "SELECT o FROM Order o "
                + "WHERE o.customer = (SELECT c FROM Customer c WHERE c.lastName = ?)";

        Query query = entityManager.createQuery(jpql).setParameter(1, "YY");
        List<Order> orders = query.getResultList();
        System.out.println(orders.size());
    }


    /**
     * JPQL 的关联查询同 HQL 的关联查询.
     */

    @Test
    public void testLeftOuterJoinFetch() {
        String jpql = "FROM Customer c LEFT OUTER JOIN FETCH c.orders WHERE c.id = ?";

        Customer customer =
                (Customer) entityManager.createQuery(jpql).setParameter(1, 1).getSingleResult();
        System.out.println(customer.getLastName());
        System.out.println(customer.getOrders().size());

//		List<Object[]> result = entityManager.createQuery(jpql).setParameter(1, 12).getResultList();
//		System.out.println(result);
    }

    //查询 order 数量大于 2 的那些 Customer
    @Test
    public void testGroupBy() {
        String jpql = "SELECT o.customer FROM Order o "
                + "GROUP BY o.customer "
                + "HAVING count(o.id) >= 2";
        List<Customer> customers = entityManager.createQuery(jpql).getResultList();

        System.out.println(customers);
    }

    @Test
    public void testOrderBy() {
        String jpql = "FROM Customer c WHERE c.age > ? ORDER BY c.age DESC";
        Query query = entityManager.createQuery(jpql).setHint(QueryHints.HINT_CACHEABLE, true);

        //占位符的索引是从 1 开始
        query.setParameter(1, 1);
        List<Customer> customers = query.getResultList();
        System.out.println(customers.size());
    }

    //使用 hibernate 的查询缓存.
    @Test
    public void testQueryCache() {
        String jpql = "FROM Customer c WHERE c.age > ?";
        Query query = entityManager.createQuery(jpql).setHint(QueryHints.HINT_CACHEABLE, true);

        //占位符的索引是从 1 开始
        query.setParameter(1, 1);
        List<Customer> customers = query.getResultList();
        System.out.println(customers.size());

        query = entityManager.createQuery(jpql).setHint(QueryHints.HINT_CACHEABLE, true);

        //占位符的索引是从 1 开始
        query.setParameter(1, 1);
        customers = query.getResultList();
        System.out.println(customers.size());
    }

    //createNativeQuery 适用于本地 SQL
    @Test
    public void testNativeQuery() {
        String sql = "SELECT age FROM JPA_CUSTOMERS WHERE id = ?";
        Query query = entityManager.createNativeQuery(sql).setParameter(1, 1);

        Object result = query.getSingleResult();
        System.out.println(result);
    }

    //createNamedQuery 适用于在实体类前使用 @NamedQuery 标记的查询语句
    @Test
    public void testNamedQuery() {
        Query query = entityManager.createNamedQuery("testNamedQuery").setParameter(1, 1);
        Customer customer = (Customer) query.getSingleResult();

        System.out.println(customer);
    }

    //默认情况下, 若只查询部分属性, 则将返回 Object[] 类型的结果. 或者 Object[] 类型的 List.
    //也可以在实体类中创建对应的构造器, 然后再 JPQL 语句中利用对应的构造器返回实体类的对象.
    @Test
    public void testPartlyProperties() {
        String jpql = "SELECT new Customer(c.lastName, c.age) FROM Customer c WHERE c.id > ?";
        List result = entityManager.createQuery(jpql).setParameter(1, 1).getResultList();

        System.out.println(result);
    }

    @Test
    public void testHelloJPQL() {
        String jpql = "FROM Customer c WHERE c.age > ?";
        Query query = entityManager.createQuery(jpql);

        //占位符的索引是从 1 开始
        query.setParameter(1, 1);
        List<Customer> customers = query.getResultList();
        System.out.println(customers.size());
    }
    

}

