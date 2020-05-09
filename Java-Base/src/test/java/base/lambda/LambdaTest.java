package base.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * lambda表达式的使用
 * 1.举例：(o1,o2)->Integer.compare(o1,o2);
 * 2.格式：
 * ->：lambda操作符 或  箭头操作符
 * ->左边：lambda形参列表（其实就是接口中的抽象方法和形参列表）
 * ->右边：lambda体（其实就是重写的抽象方法的方法体）
 * 3.Lambda表达式的使用(分为6种情况讨论)
 * 4.Lambda表达式的本质：作为函数式接口的实例
 * 5.如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口。我们可以在接口上使用@FunctionalInterface注解，这样做可以检查他是否是一个函数式接口。
 * 6.所有以前用匿名实现类表示的现在都可以用lambda表达式来写。
 * 总结：
 * ->左边：lambda形参列表的参数类型可以省略（类型推断）；如果lambda形参列表只有一对()可以省略。
 * ->右边：lambda体应该是使用一对{}包裹；如果lambda体只有一条执行语句（可能是return语句），可以省略这对{}和return关键字
 */
public class LambdaTest {
    //语法格式一： 无参  无返回值
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();
        System.out.println("------------------------");
        Runnable r2 = () -> {
            System.out.println("我爱北京故宫");
        };
        r2.run();
    }

    //语法格式二：Lambda需要一个参数，但是没有返回值
    @Test
    public void test2() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s = [" + s + "]");
            }
        };
        consumer.accept("aa");
        System.out.println();
        Consumer<String> consumer1 = (String s) -> {
            System.out.println("s = [" + s + "]");
        };
        consumer1.accept("bb");
    }

    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void test3() {
        Consumer<String> consumer1 = (String s) -> {
            System.out.println("s = [" + s + "]");
        };
        consumer1.accept("bb");
        System.out.println();
        Consumer<String> consumer2 = (s) -> {
            System.out.println("s = [" + s + "]");
        };
        consumer2.accept("cc");
    }

    //语法格式四：lambda若是只需要一个参数时，参数的小括号可以省略。
    @Test
    public void test4() {
        Consumer<String> consumer1 = (String s) -> {
            System.out.println("s = [" + s + "]");
        };
        consumer1.accept("bb");
        System.out.println();
        Consumer<String> consumer2 = s -> {
            System.out.println("s = [" + s + "]");
        };
        consumer2.accept("dd");
    }

    //语法格式五：lambda需要两个或以上参数时，多条执行语句，并且有返回值。
    @Test
    public void test5() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println("compare1 = " + compare1);

        System.out.println("-------------");

        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        int compare2 = com2.compare(12, 21);
        System.out.println("compare2 = " + compare2);
    }

    //语法格式六：当lambda体只有一台语句时，return与大括号若有，都可以省略。
    @Test
    public void test7() {
        Comparator<Integer> com1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        int compare1 = com1.compare(12, 6);
        System.out.println("compare1 = " + compare1);
        System.out.println("------------------");
        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        int compare2 = com2.compare(12, 21);
        System.out.println("compare2 = " + compare2);
    }

}
