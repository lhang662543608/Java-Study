package base.operation;

import org.junit.Test;

import java.util.Random;

public class TestOperation {
    /**
     * >>带符号右移 和 <<左移
     */
    @Test
    public void testOperation1() {
        System.out.println(0 >> 1);//0
        System.out.println(0 << 1);//0
        System.out.println(10 >> 1);//5
        System.out.println(10 << 1);//20
        System.out.println(15 >> 1);//7
        System.out.println(15 << 1);//30

        System.out.println(1 << 0);//2的0次幂
        System.out.println(1 << 1);//2的1次幂
        System.out.println(1 << 2);//2的2次幂
    }

    /**
     * 测试== 和 equals
     */
    @Test
    public void testEquals() {
        if (42 == 42.0)  // true
            System.out.println("42 == 42.0");
        if (42 == 42.0F)  // true
            System.out.println("42 == 42.0F");
        if (42 == 42L)  // true
            System.out.println("42 == 42L");
        if ("42" == "42")  // true
            System.out.println("\"42\"" + "==" + "\"42\"");

        String a = "1" + "2";
        String b = "12";
        if (a == b)
            System.out.println("\"1\"" + "+" + "\"2\"" + "==" + "\"12\"");

        String c = new String("1");
        String d = c + "2";//调用StringBuilder添加"2",最后转化为String类型
        String e = "12";
        if (d == e)
            System.out.println(d == e);
    }

    /**
     * ^异或  &与  |或  ~按位取反 ！非
     */
    @Test
    public void testOperation2() {
        System.out.println(1 & 2);//0
        System.out.println(1 | 2);//3
        System.out.println(1 ^ 2);//3

        System.out.println(~6);//-7

        System.out.println(3 ^ 7 ^ 7);//3
        System.out.println(3 ^ 7 ^ 3);//7
    }

    /***
     * 验证算法(hash%length)与(hash&(length-1))的相等关系
     */
    @Test
    public void testModeAnd() {
        //JDK1.8
        int hash = new Random().nextInt();
        System.out.println("hash:" + hash);
        int length = 16;//长度必须为2的幂次
        System.out.println((hash % length) == (hash & (length - 1)));
        length = 32;
        System.out.println((hash % length) == (hash & (length - 1)));
        length = 64;
        System.out.println((hash % length) == (hash & (length - 1)));
        length = 128;
        System.out.println((hash % length) == (hash & (length - 1)));
        length = 256;
        System.out.println((hash % length) == (hash & (length - 1)));
    }


    /**
     * 验证>>>运算
     */
    @Test
    public void testUnsignedRightShift() {
        System.out.println(11 >>> 1);//5
        System.out.println(-12 >>> 1);//2147483642
        System.out.println("**************************");
        System.out.println(UnsignedRightShiftOperation(32));
        System.out.println(UnsignedRightShiftOperation(31));
        System.out.println(UnsignedRightShiftOperation(30));

    }


    static int UnsignedRightShiftOperation(int n) {
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }

    /**
     * 验证HashMap的tableSizeFor方法
     * JDK1.8
     */
    @Test
    public void TestTableSizeFor() {
        System.out.println(tableSizeFor(16));
        System.out.println(tableSizeFor(17));
        System.out.println(tableSizeFor(32));
        System.out.println(tableSizeFor(33));
        System.out.println(tableSizeFor(64));
    }


    /********************Method**************************************/
    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


    /***
     * JDK1.7 JDK1.8的hash方法测试
     */
    @Test
    public void testHashMapHash() {
        System.out.println(hash_7("key".hashCode()));
        System.out.println(hash_8("key"));
    }

    static final int hash_8(Object key) {
        int h;
        // key.hashCode()：返回散列值也就是hashcode
        // ^ ：按位异或
        // >>>:无符号右移，忽略符号位，空位都以0补齐
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static int hash_7(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }


    @Test
    public void testNum() {
        System.out.println(2147483647 == 0x7FFFFFFF);//16进制
        System.out.println(2147483647 == 017777777777);//8进制
        System.out.println(2147483647 == 0b1111111111111111111111111111111);//2进制
        /**
         * true
         * true
         * true
         */
    }

    /**
     * 笔试题:逻辑运算符
     */
    @Test
    public void testLogicalOperators() {
        boolean x = true;
        boolean y = false;
        short z = 42;
        if (y == true)
            if ((z++ == 42) && (y = true))
                z++;
        if ((x = false) || (++z) == 45)//z++
            z++;
        System.out.println("z=" + z);//43

    }

    /**
     * 笔试题：交换两个变量的值
     */
    @Test
    public void testSwapValue() {
//        int[] arr1 = new int[1070333948];
        int num1 = 12;
        int num2 = 5;
        /**
         * 好处：不用定义临时变量
         * 弊端：有局限性：只能使用数值型
         */
        //方式一
        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
        System.out.println("num1=" + num1);
        System.out.println("num2=" + num2);

        /**
         * 好处：不用定义临时变量
         * 弊端：①可能存在数据溢出
         *      ②有局限性：只能使用数值型
         */
        //方式二
        int a = 1;
        int b = 2;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a=" + a);
        System.out.println("b=" + b);

        /**
         * 推荐使用
         */
        //方式三
        int c = 3, d = 4, e;
        e = c;
        c = d;
        d = e;
        System.out.println("c=" + c + ",d=" + d);
    }

}
