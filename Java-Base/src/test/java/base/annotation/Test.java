package java.base.annotation;


public class Test {
    /**
     * JDK提供的四种元注解
     * 元注解：对现有的注解进行解释说明的注解
     * 1.Retention：指定所修饰的Annotation的生命周期：SOURCE|CLASS（默认行为）|RUNTIME
     * 2.Target：用于指定被修饰的Annotation能用于修饰哪些程序元素
     * ===============以下两个出线频率较低============================
     * 3.Documented：用于指定给该元Annotation修饰的Annotation将被JavaDoc工具提取成文档。默认不包含注解
     * 4.Inherited：被它修饰的注解将具有继承性
     */


    /**
     * 通过反射获取注解信息
     */


    /**
     * Java8中的注解新特性;
     * 可重复注解：①在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
     *             ②MyAnnotation的Target和Retention等元注解和MyAnnotations相同
     *
     *  类型注解：
     *  ElementType.TYPE_PARAMETER  表示该注解能写在类型变量的声明语句中
     *  ElementType.TYPE_USE 表示该注解能生命在使用类型的任何语句中。
     */
}
