package base.reflect;

import org.junit.Test;

public class InterfacesTest {
    @Test
    public void test(){
        Class personClass = Person.class;
        //getInterfaces():获取运行时类实现的接口
        Class[] interfaces = personClass.getInterfaces();
        for (Class c :
                interfaces) {
            System.out.println(c);
        }
        System.out.println("---------------------------------");
        //获取运行时类的父类实现的接口
        Class[] interfaces1 = personClass.getSuperclass().getInterfaces();
        for (Class cc :
                interfaces1) {
            System.out.println(cc);
        }
    }
}
