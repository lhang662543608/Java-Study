package base.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java内置的四大核心函数式接口
 * 消费型接口：Consumer<T> void accept(T t)
 * 供给型接口：Supplier<T> T get()
 * 函数型接口：Function<T,R> R apply(T t)
 * 断定型接口：Predicate<T> boolean test(T t)
 */
public class FunctionalInterfaceTest {
    @Test
    public void test1() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习很累，去KTV消费" + aDouble + "元钱");
            }
        });

        System.out.println("--------------------------");
        happyTime(400, money -> System.out.println("学习很累，去KTV消费" + money + "元钱"));
    }

    public void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","南京","天津","东京","普京");
        ArrayList<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(list1);

        System.out.println("------------------------------");
        ArrayList<String> filterString = filterString(list, s -> s.contains("京"));
        System.out.println(filterString);
    }

    //根据给定的规则过滤集合中的字符串。此规则由Predicate的方法决定。
    public ArrayList<String> filterString(List<String> list, Predicate<String> predicate) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s :
                list) {
            if (predicate.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;

    }
}
