package base.reflect;

import org.junit.Test;

public class PackageTest {
    @Test
    public void test() {
        Class personClass = Person.class;
        //getPackage():获取运行时类所在的包
        Package classPackage = personClass.getPackage();
        System.out.println(classPackage);
    }
}
