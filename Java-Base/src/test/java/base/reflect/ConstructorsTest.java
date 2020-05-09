package base.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class ConstructorsTest {
    @Test
    public void test() {
        Class clazz = Person.class;

        //getConstructors():获取当前运行时类声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c :
                constructors) {
            System.out.println(c);
        }

        System.out.println();
        //getDeclaredConstructors():获取当前运行时类声明的所有构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c :
                declaredConstructors) {
            System.out.println(c);
        }
    }
}
