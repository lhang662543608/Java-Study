package test;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author lhang
 * @create 2020-06-28 7:11
 */
public class HibernateTest {
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
    public void testBlob() throws Exception{
//        User user = new User();
//        InputStream stream = new FileInputStream("1.jpg");
//        System.out.println(stream);
//        Blob image = Hibernate.getLobCreator(session)
//				              .createBlob(stream, stream.available());
//
//		user.setUserName("John");
//		user.setDate(new Date());
//		user.setHeadImage(image);
//		session.save(user);

        User user1 =  session.get(User.class, 1);
        Blob image = user1.getHeadImage();

        InputStream in = image.getBinaryStream();
        System.out.println(in.available());
    }

    /**
     * 会出现并发问题
     * @throws InterruptedException
     */
    @Test
    public void testIdGenerator() throws InterruptedException{
        User user = new User("BB",new Date());
        session.save(user);

//		Thread.sleep(5000);
    }

    @Test
    public void testDoWork(){
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println( connection );
            }
        });
    }

    /**
     * evict: 从 session 缓存中把指定的持久化对象移除
     */
    @Test
    public void testEvict(){
        User user1 =  session.get(User.class, 1);
        User user2 =  session.get(User.class, 2);

        user1.setUserName("AA");
        user2.setUserName("BB");

        session.evict(user1);
    }


    /**
     * delete: 执行删除操作. 只要 OID 和数据表中一条记录对应, 就会准备执行 delete 操作
     * 若 OID 在数据表中没有对应的记录, 则抛出异常
     * <p>
     * 可以通过设置 hibernate 配置文件 hibernate.use_identifier_rollback 为 true,
     * 使删除对象后, 把其 OID 置为  null
     */
    @Test
    public void testDelete() {
//		User user = new User();
//		user.setUserID(11);

        User user = session.get(User.class, 11);
        session.delete(user);

        System.out.println(user);
    }

    /**
     * 注意:
     * 1. 若 OID 为 null, 但数据表中没有与其对应的记录. 会执行Insert
     * 若 OID 不为 null, 会执行update
     * 2. 了解: OID 值等于 id 的 unsaved-value 属性值的对象, 也被认为是一个游离对象
     */
    @Test
    public void testSaveOrUpdate() {
        User news = new User("BBB");
        news.setUserID(11);

        session.saveOrUpdate(news);
    }

    /**
     * update:
     * 1. 若更新一个持久化对象, 不需要显示的调用 update 方法. 因为在调用 Transaction
     * 的 commit() 方法时, 会先执行 session 的 flush 方法.
     * 2. 更新一个游离对象, 需要显式的调用 session 的 update 方法. 可以把一个游离对象
     * 变为持久化对象
     * <p>
     * 需要注意的:
     * 1. 无论要更新的游离对象和数据表的记录是否一致, 都会发送 UPDATE 语句.
     * 如何能让 updat 方法不再盲目的出发 update 语句呢 ? 在 .hbm.xml 文件的 class 节点设置
     * select-before-update=true (默认为 false). 但通常不需要设置该属性.
     * <p>
     * 2. 若数据表中没有对应的记录, 但还调用了 update 方法, 会抛出异常
     * <p>
     * 3. 当 update() 方法关联一个游离对象时,
     * 如果在 Session 的缓存中已经存在相同 OID 的持久化对象, 会抛出异常. 因为在 Session 缓存中
     * 不能有两个 OID 相同的对象!
     */
    @Test
    public void testUpdate() {
        User user = session.get(User.class, 1);

        transaction.commit();
        session.close();

//		user.setUserID(100);

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        user.setUserName("Rose");

        User user1 = session.get(User.class, 1);
        session.update(user);
    }

    /**
     * get VS load:
     * <p>
     * 1. 执行 get 方法: 会立即加载对象.
     * 执行 load 方法, 若不适用该对象, 则不会立即执行查询操作, 而返回一个代理对象
     * <p>
     * get 是 立即检索, load 是延迟检索.
     * <p>
     * 2. load 方法可能会抛出 LazyInitializationException 异常: 在需要初始化
     * 代理对象之前已经关闭了 Session
     * <p>
     * 3. 若数据表中没有对应的记录, Session 也没有被关闭.
     * get 返回 null
     * load 若不使用该对象的任何属性, 没问题; 若需要初始化了, 抛出异常.
     */
    @Test
    public void testLoad() {

        User user = session.load(User.class, 10);
        System.out.println(user.getClass().getName());

//		session.close();
//		System.out.println(user);
    }

    @Test
    public void testGet() {
        User user = (session.get(User.class, 1));
//		session.close();
        System.out.println(user);
    }

    /**
     * persist(): 也会执行 INSERT 操作
     * <p>
     * 和 save() 的区别 :
     * 在调用 persist 方法之前, 若对象已经有 id 了, 则不会执行 INSERT, 而抛出异常
     */
    @Test
    public void testPersist() {
        User news = new User();
        news.setUserName("Jack");
        news.setUserID(200);

        session.persist(news);
    }

    /**
     * 1. save() 方法
     * 1). 使一个临时对象变为持久化对象
     * 2). 为对象分配 ID.
     * 3). 在 flush 缓存时会发送一条 INSERT 语句.
     * 4). 在 save 方法之前的 id 是无效的
     * 5). 持久化对象的 ID 是不能被修改的!
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("小邹");
        user.setUserID(100);

        System.out.println(user);

        session.save(user);

        System.out.println(user);
//		user.setUserID(101);
    }


    /**
     * clear(): 清理缓存
     */
    @Test
    public void testClear() {
        User user1 = session.get(User.class, 1);

        session.clear();

        User user2 = session.get(User.class, 1);
    }

    /**
     * refresh(): 会强制发送 SELECT 语句, 以使 Session 缓存中对象的状态和数据表中对应的记录保持一致!
     */
    @Test
    public void testRefresh() {
        User user = session.get(User.class, 1);
        System.out.println(user);

        session.refresh(user);
        System.out.println(user);
    }

    /**
     * flush: 使数据表中的记录和 Session 缓存中的对象的状态保持一致. 为了保持一致, 则可能会发送对应的 SQL 语句.
     * 1. 在 Transaction 的 commit() 方法中: 先调用 session 的 flush 方法, 再提交事务
     * 2. flush() 方法会可能会发送 SQL 语句, 但不会提交事务.
     * 3. 注意: 在未提交事务或显式的调用 session.flush() 方法之前, 也有可能会进行 flush() 操作.
     * 1). 执行 HQL 或 QBC 查询, 会先进行 flush() 操作, 以得到数据表的最新的记录
     * 2). 若记录的 ID 是由底层数据库使用自增的方式生成的, 则在调用 save() 方法时, 就会立即发送 INSERT 语句.
     * 因为 save 方法后, 必须保证对象的 ID 是存在的!
     */
    @Test
    public void testSessionFlush() {
        User user = session.get(User.class, 1);
        user.setUserName("Tom");

    }

    @Test
    public void testSessionCache() {
        User user = session.get(User.class, 1);
        System.out.println(user);

        User user1 = session.get(User.class, 1);
        System.out.println(user1);
    }

}
