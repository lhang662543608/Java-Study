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

/**
 * @author lhang
 * @create 2020-07-17 21:49
 */

public class TestSecondCache {
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


    @Test
    public void testSecondLevelCache() {
        Customer customer1 = entityManager.find(Customer.class, 1);

        transaction.commit();
        entityManager.close();

        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer2 = entityManager.find(Customer.class, 1);
    }

}

