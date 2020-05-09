package base.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

import static java.lang.annotation.ElementType.*;

/**
 * 如何自定义注解：
 * ①注解声明为@interface
 * ②内部定义成员，通常使用value来表示
 * ③可以指定成员的默认值，使用default来定义
 * ④如果自定义注解没有成员，表明这是一个标识作用
 * <p>
 * <p>
 * 自定义注解必须配合注解的信息处理流程（反射）才有意义
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(base.annotation.MyAnnotations.class)
public @interface MyAnnotation {
    String value() default "";
}


class AA<@MyAnnotation T> {
    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int) 10L;

    }

}
