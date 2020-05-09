package base.compare;

import org.junit.Test;

import java.util.Arrays;

public class TestComparable {
    /**
     * Comparable接口的使用举例:
     * 1.像String、包装类等实现了Comparable接口，重写了CompareTo方法给出了两个对象的大小的方式
     * 2.像String、包装类等重写了CompareTo()方法以后，进行了从小到大的排列
     * 3.重写compareTo(obj)的规则：
     * 如果当前对象this大于形参对象obj，则返回正整数
     * 如果当前对象this小于形参对象obj，则返回负整数
     * 如果当前对象this等于形参对象obj，则返回零
     * 4.对于自定义类来说，如果需要排序，我们可以让自定义类实现Compareable接口，重写CompareTo方法。
     * 在CompareTo()指定如何排序。
     */
    @Test
    public void test1() {
        String[] arr = {"AA", "BB", "KK", "DD", "ZZ", "MM"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("联想鼠标",35);
        arr[1] = new Goods("戴尔鼠标",45);
        arr[2] = new Goods("达尔优鼠标",25);
        arr[3] = new Goods("罗技鼠标",70);
        arr[4] = new Goods("微软鼠标",45);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
