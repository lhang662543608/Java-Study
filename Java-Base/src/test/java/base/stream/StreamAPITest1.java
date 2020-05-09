package base.stream;


import base.lambda.Employee;
import base.lambda.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试中间操作
 */
public class StreamAPITest1 {
    //1-筛选与切片
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
//        Stream<T> filter(Predicate<? super T> predicate)：接收lambda，从流中排出某些元素
        //查询员工表中薪资大于7000的员工信息
        employees.stream().filter(t -> t.getSalary() > 7000).forEach(System.out::println);

        System.out.println();

        //Stream<T> limit(long maxSize):截断流，使其元素不超过给定的数量
        employees.stream().limit(3).forEach(System.out::println);

        System.out.println();

        //Stream<T> skip(long n):跳过元素，返回一个扔掉了前n个元素的流。若流中的元素不足n个，则返回一个空流
        employees.stream().skip(3).forEach(System.out::println);

        System.out.println();

        //Stream<T> distinct():筛选，通过流所生成元素的hashCode()和equals()去除重复元素。
        employees.add(new Employee(1010, "刘强东", 40, 8000));
        employees.add(new Employee(1010, "刘强东", 40, 8000));
        employees.add(new Employee(1010, "刘强东", 40, 8000));
        employees.add(new Employee(1010, "刘强东", 40, 8000));
        employees.add(new Employee(1010, "刘强东", 40, 8000));
        employees.stream().distinct().forEach(System.out::println);
    }

    //映射
    @Test
    public void test2() {
        //map(Function f):
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        System.out.println("-------------");
        //练习1：获取员工姓名长度大于3的员工的姓名。
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().map(Employee::getName).filter(name -> name.length() > 3).forEach(System.out::println);
        System.out.println("-------------");

        //练习2：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s -> s.forEach(System.out::println));

        System.out.println("-------------");
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out::println);
        //flatMap(Function f):

    }

    //将字符串中的多个数组构成的集合转换为对应的Stream的实例。
    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c :
                str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    //3-排序
    @Test
    public void test3(){
        //sorted()--自然排序
        List<Integer> list = Arrays.asList(12, 23, 45, 11, 25, 22);
        list.stream().sorted().forEach(System.out::println);

        //sorted(Compartor com)--定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2)-> Integer.compare(e1.getAge(),e2.getAge() )).forEach(System.out::println);
    }
}
