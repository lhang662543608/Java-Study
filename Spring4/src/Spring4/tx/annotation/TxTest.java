package Spring4.tx.annotation;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author lhang
 * @create 2020-07-09 10:13
 */
public class TxTest {
    private ClassPathXmlApplicationContext ctx = null;
    private BookShopDao bookShopDao = null;
    private Cashier cashier;
    private BookShopService bookShopService;

    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("transaction-annotation.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        cashier = ctx.getBean(Cashier.class);
        bookShopService = ctx.getBean(BookShopService.class);
    }

    @After
    public void tearDown() throws Exception {
        ctx.close();
    }

    @Test
    public void testTransactionlPropagation() {
        cashier.checkout("AA", Arrays.asList("1001", "1002"));
    }

    @Test
    public void testBookShopService() {
        bookShopService.purchase("AA", "1001");
    }

    @Test
    public void findBookPriceByIsbn() throws Exception {
        int price = bookShopDao.findBookPriceByIsbn("1001");
        System.out.println("price = " + price);
    }

    @Test
    public void updateBookStock() throws Exception {
        bookShopDao.updateBookStock("1001");
    }

    @Test
    public void updateUserAccount() throws Exception {
        bookShopDao.updateUserAccount("Jack", 500);
    }

}