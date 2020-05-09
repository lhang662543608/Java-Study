package base.singleton;


import base.singletondemo.SingletonDemo1;
import base.singletondemo.SingletonDemo2;
import org.junit.Test;

public class TestSingleton {

    @Test
    public void TestSingletonDemo1(){
        SingletonDemo1 singletonDemo1 = SingletonDemo1.getInstance();
        SingletonDemo1 singletonDemo2 = SingletonDemo1.getInstance();
        SingletonDemo1 singletonDemo3 = SingletonDemo1.getInstance();
        System.out.println(singletonDemo1== singletonDemo2);
        System.out.println(singletonDemo2== singletonDemo3);
    }



    @Test
    public void TestSingletonDemo2(){
        SingletonDemo2 singletonDemo1 = SingletonDemo2.getInstance();
        SingletonDemo2 singletonDemo2 = SingletonDemo2.getInstance();
        SingletonDemo2 singletonDemo3 = SingletonDemo2.getInstance();
        System.out.println(singletonDemo1== singletonDemo2);
        System.out.println(singletonDemo2== singletonDemo3);
    }
}
