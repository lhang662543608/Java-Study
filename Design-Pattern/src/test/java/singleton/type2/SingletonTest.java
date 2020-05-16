package singleton.type2;

import org.junit.Test;

/**
 * @author lhang
 * @create 2020-05-16 8:49
 */
public class SingletonTest {
    @Test
    public void getInstance() throws Exception {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }

}