package test;

import entity.Pay;
import entity.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lhang
 * @create 2020-07-01 10:11
 */
public class HibernateTest2 {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {
        //创建 Configuration对象
        Configuration configuration = new Configuration();
        configuration = configuration.configure();
        //创建一个 SessionFactory 对象
        sessionFactory = configuration.buildSessionFactory();
        //创建一个 Session 对象
        session = sessionFactory.openSession();
        //开启事务
        transaction = session.beginTransaction();
    }

    @After
    public void destory() {
        //提交事务
        transaction.commit();
        //关闭session
        session.close();
        //关闭sessionFactory
        sessionFactory.close();
    }

    @Test
    public void testComponent() {
        Worker worker = new Worker();
        Pay pay = new Pay();

        pay.setMonthlyPay(1000);
        pay.setVocationWithPay(5);
        pay.setYearPay(8000000);

        worker.setName("AAAA");
        worker.setPay(pay);

        session.save(worker);
    }


}
