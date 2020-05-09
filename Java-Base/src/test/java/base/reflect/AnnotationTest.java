package base.reflect;

import org.junit.Test;

import java.lang.annotation.Annotation;

public class AnnotationTest {
    @Test
    public void test(){
        Class personClass = Person.class;
        //getPackage():获取运行时类的注解
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation a :
                annotations) {
            System.out.println(a);
        }
    }
}
