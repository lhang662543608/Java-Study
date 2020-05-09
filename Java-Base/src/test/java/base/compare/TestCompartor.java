package base.compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Compartor接口的使用;定制排序
 * 1.背景：
 * 当元素的类型没有实现java.lang.Comaprable接口，又不方便修改代码，
 * 或者实现了java.lang.Comaprable接口的排序规则不适合当前规则，
 * 那么这种这种情况可以考虑使用Compartor的对象来排序。
 * 2.重写comapre(Object o1,Object o2)方法,比较o1和o2的大小
 */
public class TestCompartor {
    @Test
    public void test1() {
        String[] arr = {"AA", "BB", "KK", "DD", "ZZ", "MM"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("联想鼠标",35);
        arr[1] = new Goods("联想鼠标",45);
        arr[2] = new Goods("达尔优鼠标",25);
        arr[3] = new Goods("罗技鼠标",70);
        arr[4] = new Goods("微软鼠标",45);

        Arrays.sort(arr, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if (o1.getName().equals(o2.getName())){
                    return Double.compare(o1.getPrice(),o2.getPrice());
                }else {
                    return o1.getName().compareTo(o2.getName());
                }

            }
        });
        System.out.println(Arrays.toString(arr));
    }

}
