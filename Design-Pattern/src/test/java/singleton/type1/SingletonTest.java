package singleton.type1;

import org.junit.Test;

/**
 * @author lhang
 * @create 2020-05-16 8:44
 */
public class SingletonTest {
    @Test
    public void getInstance() throws Exception {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }

}