package jpa.spring;

import jpa.spring.entities.*;
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
 * @create 2020-07-17 21:49
 */

public class TestRelatedrelationship {
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


    //对于关联的集合对象, 默认使用懒加载的策略.
    //使用维护关联关系的一方获取, 还是使用不维护关联关系的一方获取, SQL 语句相同.
    @Test
    public void testManyToManyFind() {
//		Item item = entityManager.find(Item.class, 5);
//		System.out.println(item.getItemName());
//
//		System.out.println(item.getCategories().size());

        Category category = entityManager.find(Category.class, 3);
        System.out.println(category.getCategoryName());
        System.out.println(category.getItems().size());
    }

    //多对所的保存
    @Test
    public void testManyToManyPersist() {
        Item i1 = new Item();
        i1.setItemName("i-1");

        Item i2 = new Item();
        i2.setItemName("i-2");

        Category c1 = new Category();
        c1.setCategoryName("C-1");

        Category c2 = new Category();
        c2.setCategoryName("C-2");

        //设置关联关系
        i1.getCategories().add(c1);
        i1.getCategories().add(c2);

        i2.getCategories().add(c1);
        i2.getCategories().add(c2);

        c1.getItems().add(i1);
        c1.getItems().add(i2);

        c2.getItems().add(i1);
        c2.getItems().add(i2);

        //执行保存
        entityManager.persist(i1);
        entityManager.persist(i2);
        entityManager.persist(c1);
        entityManager.persist(c2);
    }

    //1. 默认情况下, 若获取不维护关联关系的一方, 则也会通过左外连接获取其关联的对象.
    //可以通过 @OneToOne 的 fetch 属性来修改加载策略. 但依然会再发送 SQL 语句来初始化其关联的对象
    //这说明在不维护关联关系的一方, 不建议修改 fetch 属性.
    @Test
    public void testOneToOneFind2() {
        Manager mgr = entityManager.find(Manager.class, 1);
        System.out.println(mgr.getMgrName());

        System.out.println(mgr.getDept().getClass().getName());
    }

    //1.默认情况下, 若获取维护关联关系的一方, 则会通过左外连接获取其关联的对象.
    //但可以通过 @OntToOne 的 fetch 属性来修改加载策略.
    @Test
    public void testOneToOneFind() {
        Department dept = entityManager.find(Department.class, 1);
        System.out.println(dept.getDeptName());
        System.out.println(dept.getMgr().getClass().getName());
    }

    //双向 1-1 的关联关系, 建议先保存不维护关联关系的一方, 即没有外键的一方, 这样不会多出 UPDATE 语句.
    @Test
    public void testOneToOnePersistence() {
        Manager mgr = new Manager();
        mgr.setMgrName("M-BB");

        Department dept = new Department();
        dept.setDeptName("D-BB");

        //设置关联关系
        mgr.setDept(dept);
        dept.setMgr(mgr);

        //执行保存操作
        entityManager.persist(mgr);
        entityManager.persist(dept);
    }

    @Test
    public void testUpdate() {
        Customer customer = entityManager.find(Customer.class, 10);

        customer.getOrders().iterator().next().setOrderName("O-XXX-10");
    }

    //默认情况下, 若删除 1 的一端, 则会先把关联的 n 的一端的外键置空, 然后进行删除.
    //可以通过 @OneToMany 的 cascade 属性来修改默认的删除策略.
    @Test
    public void testOneToManyRemove() {
        Customer customer = entityManager.find(Customer.class, 8);
        entityManager.remove(customer);
    }

    //默认对关联的多的一方使用懒加载的加载策略.
    //可以使用 @OneToMany 的 fetch 属性来修改默认的加载策略
    @Test
    public void testOneToManyFind() {
        Customer customer = entityManager.find(Customer.class, 9);
        System.out.println(customer.getLastName());

        System.out.println(customer.getOrders().size());
    }

    //若是双向 1-n 的关联关系, 执行保存时
    //若先保存 n 的一端, 再保存 1 的一端, 默认情况下, 会多出 n 条 UPDATE 语句.
    //若先保存 1 的一端, 则会多出 n 条 UPDATE 语句
    //在进行双向 1-n 关联关系时, 建议使用 n 的一方来维护关联关系, 而 1 的一方不维护关联系, 这样会有效的减少 SQL 语句.
    //注意: 若在 1 的一端的 @OneToMany 中使用 mappedBy 属性, 则 @OneToMany 端就不能再使用 @JoinColumn 属性了.

    //单向 1-n 关联关系执行保存时, 一定会多出 UPDATE 语句.
    //因为 n 的一端在插入时不会同时插入外键列.
    @Test
    public void testOneToManyPersist() {
        Customer customer = new Customer();
        customer.setAge(18);
        customer.setBirth(new Date());
        customer.setCreateTime(new Date());
        customer.setEmail("mm@163.com");
        customer.setLastName("MM");

        Order order1 = new Order();
        order1.setOrderName("O-MM-1");

        Order order2 = new Order();
        order2.setOrderName("O-MM-2");

        //建立关联关系
        customer.getOrders().add(order1);
        customer.getOrders().add(order2);

        order1.setCustomer(customer);
        order2.setCustomer(customer);

        //执行保存操作
        entityManager.persist(customer);

        entityManager.persist(order1);
        entityManager.persist(order2);
    }

}

/*    @Test
    public void testManyToOneUpdate() {
        Order order = entityManager.find(Order.class, 2);
        order.getCustomer().setLastName("FFF");
    }

    //不能直接删除 1 的一端, 因为有外键约束.
    @Test
    public void testManyToOneRemove() {
//		Order order = entityManager.find(Order.class, 1);
//		entityManager.remove(order);

        Customer customer = entityManager.find(Customer.class, 7);
        entityManager.remove(customer);
    }

    //默认情况下, 使用左外连接的方式来获取 n 的一端的对象和其关联的 1 的一端的对象.
    //可使用 @ManyToOne 的 fetch 属性来修改默认的关联属性的加载策略
    @Test
    public void testManyToOneFind() {
        Order order = entityManager.find(Order.class, 1);
        System.out.println(order.getOrderName());

        System.out.println(order.getCustomer().getLastName());
    }


    *//**
 * 保存多对一时, 建议先保存 1 的一端, 后保存 n 的一端, 这样不会多出额外的 UPDATE 语句.
 *//*
    @Test
    public void testManyToOnePersist() {
        Customer customer = new Customer();
        customer.setAge(18);
        customer.setBirth(new Date());
        customer.setCreateTime(new Date());
        customer.setEmail("gg@163.com");
        customer.setLastName("GG");

        Order order1 = new Order();
        order1.setOrderName("G-GG-1");

        Order order2 = new Order();
        order2.setOrderName("G-GG-2");

        //设置关联关系
        order1.setCustomer(customer);
        order2.setCustomer(customer);

        //执行保存操作
        entityManager.persist(order1);
        entityManager.persist(order2);

        entityManager.persist(customer);
    }
}*/

