package Spring4.tx.xml;


import Spring4.tx.xml.service.BookShopService;
import Spring4.tx.xml.service.Cashier;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class TxTest {
    private ClassPathXmlApplicationContext ctx = null;
    private BookShopDao bookShopDao = null;
    private Cashier cashier;
    private BookShopService bookShopService;

    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("transaction-xml.xml");
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
        cashier.checkout("Jack", Arrays.asList("1001", "1002"));
    }

    @Test
    public void testBookShopService() {
        bookShopService.purchase("Jack", "1001");
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