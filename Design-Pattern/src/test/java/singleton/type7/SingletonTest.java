package singleton.type7;

import org.junit.Test;

/**
 * @author lhang
 * @create 2020-05-16 10:13
 */
public class SingletonTest {
    @Test
    public void test(){
        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance1==instance2);
    }
}