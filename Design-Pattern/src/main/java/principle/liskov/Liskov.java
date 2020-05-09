package principle.liskov;

/**
 * @author lhang
 * @create 2020-05-09 23:18
 */
public class Liskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3="+a.func1(11,3));
        System.out.println("1-8="+a.func1(1,8));

        System.out.println("**************");
        B b = new B();
        System.out.println("11-3="+b.func1(11,3));//这里的本意是求出11-3的结构
        System.out.println("1-8="+b.func1(1,8));//这里的本意是求是1-8的结果
        System.out.println("11+3+9="+b.func2(11,3));

    }
}
//A类
class A{
    //返回两个数的差
    public int func1(int num1,int num2){
        return  num1-num2;
    }
}
//B类继承了A类
//增加一个新功能，完成两个数的相加，然后和9求和。
class B extends A{
    @Override
    public int func1(int num1, int num2) {
        return num1+num2;
    }

    public int func2(int num1,int num2){
        return func1(num1,num2)+9;
    }
}