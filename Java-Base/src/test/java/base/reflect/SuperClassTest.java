package base.reflect;


import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class SuperClassTest {
    /**
     * 获取运行时类的父类
     */
    @Test
    public void test() {
        Class personClass = Person.class;
        Class superclass = personClass.getSuperclass();
        System.out.println("superclass = " + superclass);
    }

    /**
     * 获取运行时类的带泛型的父类
     */
    @Test
    public void test1(){
        Class personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    //获取运行时类的带泛型父类的泛型
    @Test
    public void test2(){
        Class personClass = Person.class;
        ParameterizedType parameterizedType = (ParameterizedType) personClass.getGenericSuperclass();
        //获取泛型的类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            System.out.println(actualTypeArguments[i].getTypeName());
        }
    }
}
