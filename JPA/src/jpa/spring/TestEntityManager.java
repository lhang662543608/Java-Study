package jpa.spring;

import jpa.spring.entities.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Date;

/**
 * @author lhang
 * @create 2020-07-18 8:13
 */
public class TestEntityManager {
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
    public void before(){
        transaction.begin();
    }
    @After
    public void after(){
        transaction.commit();
    }

    /**
     * 同 hibernate 中 Session 的 refresh 方法.
     */
    @Test
    public void testRefresh(){
        Customer customer = entityManager.find(Customer.class, 1);
        customer = entityManager.find(Customer.class, 1);

        entityManager.refresh(customer);
    }

    /**
     * 同 hibernate 中 Session 的 flush 方法.
     */
    @Test
    public void testFlush(){
        Customer customer = entityManager.find(Customer.class, 1);
        System.out.println(customer);

        customer.setLastName("AA");

        entityManager.flush();
    }

    //若传入的是一个游离对象, 即传入的对象有 OID.
    //1. 若在 EntityManager 缓存中有对应的对象
    //2. JPA 会把游离对象的属性复制到查询到EntityManager 缓存中的对象中.
    //3. EntityManager 缓存中的对象执行 UPDATE.
    @Test
    public void testMerge4(){
        Customer customer = new Customer();
        customer.setAge(18);
        customer.setBirth(new Date());
        customer.setCreateTime(new Date());
        customer.setEmail("dd@163.com");
        customer.setLastName("DD");

        customer.setId(4);
        Customer customer2 = entityManager.find(Customer.class, 4);

        entityManager.merge(customer);

        System.out.println(customer == customer2); //false
    }

    //若传入的是一个游离对象, 即传入的对象有 OID.
    //1. 若在 EntityManager 缓存中没有该对象
    //2. 若在数据库中也有对应的记录
    //3. JPA 会查询对应的记录, 然后返回该记录对一个的对象, 再然后会把游离对象的属性复制到查询到的对象中.
    //4. 对查询到的对象执行 update 操作.
    @Test
    public void testMerge3(){
        Customer customer = new Customer();
        customer.setAge(18);
        customer.setBirth(new Date());
        customer.setCreateTime(new Date());
        customer.setEmail("ee@163.com");
        customer.setLastName("EE");

        customer.setId(4);

        Customer customer2 = entityManager.merge(customer);

        System.out.println(customer == customer2); //false
    }

    //若传入的是一个游离对象, 即传入的对象有 OID.
    //1. 若在 EntityManager 缓存中没有该对象
    //2. 若在数据库中也没有对应的记录
    //3. JPA 会创建一个新的对象, 然后把当前游离对象的属性复制到新创建的对象中
    //4. 对新创建的对象执行 insert 操作.
    @Test
    public void testMerge2(){
        Customer customer = new Customer();
        customer.setAge(18);
        customer.setBirth(new Date());
        customer.setCreateTime(new Date());
        customer.setEmail("dd@163.com");
        customer.setLastName("DD");

        customer.setId(100);

        Customer customer2 = entityManager.merge(customer);

        System.out.println("customer#id:" + customer.getId());
        System.out.println("customer2#id:" + customer2.getId());
    }

    /**
     * 总的来说: 类似于 hibernate Session 的 saveOrUpdate 方法.
     */
    //1. 若传入的是一个临时对象
    //会创建一个新的对象, 把临时对象的属性复制到新的对象中, 然后对新的对象执行持久化操作. 所以
    //新的对象中有 id, 但以前的临时对象中没有 id.
    @Test
    public void testMerge1(){
        Customer customer = new Customer();
        customer.setAge(18);
        customer.setBirth(new Date());
        customer.setCreateTime(new Date());
        customer.setEmail("cc@163.com");
        customer.setLastName("CC");

        Customer customer2 = entityManager.merge(customer);

        System.out.println("customer#id:" + customer.getId());
        System.out.println("customer2#id:" + customer2.getId());
    }

    //类似于 hibernate 中 Session 的 delete 方法. 把对象对应的记录从数据库中移除
    //但注意: 该方法只能移除 持久化 对象. 而 hibernate 的 delete 方法实际上还可以移除 游离对象.
    @Test
    public void testRemove(){
//		Customer customer = new Customer();
//		customer.setId(2);

        Customer customer = entityManager.find(Customer.class, 2);
        entityManager.remove(customer);
    }

    //类似于 hibernate 的 save 方法. 使对象由临时状态变为持久化状态.
    //和 hibernate 的 save 方法的不同之处: 若对象有 id, 则不能执行 insert 操作, 而会抛出异常.
    @Test
    public void testPersistence(){
        Customer customer = new Customer();
        customer.setAge(15);
        customer.setBirth(new Date());
        customer.setCreateTime(new Date());
        customer.setEmail("bb@163.com");
        customer.setLastName("BB");
//        customer.setId(100);

        entityManager.persist(customer);
        System.out.println(customer.getId());
    }

    //类似于 hibernate 中 Session 的 load 方法
    @Test
    public void testGetReference(){
        Customer customer = entityManager.getReference(Customer.class, 1);
        System.out.println(customer.getClass().getName());

        System.out.println("-------------------------------------");
//		transaction.commit();
//		entityManager.close();

        System.out.println(customer);
    }

    //类似于 hibernate 中 Session 的 get 方法.
    @Test
    public void testFind() {
        Customer customer = entityManager.find(Customer.class, 1);
        System.out.println("-------------------------------------");

        System.out.println(customer);
    }
}
