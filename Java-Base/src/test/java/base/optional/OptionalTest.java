package base.optional;

import org.junit.Test;

import java.util.Optional;
/**
 * Optional.of(T t):创建一个Optional实例，t必须非空
 * Optional.empty():
 * Optional.ofNullable(T t):t可以为null
 *
 * 常用的方法：
 *      ofNullable(T t)
 *      ofElse(T t):
 */
public class OptionalTest {

    @Test
    public void test1() {
        Girl girl = new Girl();
        girl = null;
        //of(T t):保证t是非空的
        Optional<Girl> girlOptional = Optional.of(girl);
    }

    @Test
    public void test2() {
        Girl girl = new Girl();
        girl = null;
        //ofNullable(T t):t可以为null
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        System.out.println("girlOptional = " + girlOptional);
        //orElse():如果当前中内部封装的t是非空的，则饭hi内部的t
        //如果内部的t是空的，则返回orElse()方法中的参数t1
        Girl girl1 = girlOptional.orElse(new Girl("赵丽颖"));
        System.out.println("girl1 = " + girl1);
    }

    @Test
    public void test3() {
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName(boy);
        System.out.println("girlName = " + girlName);
    }

    @Test
    public void test4() {
        Boy boy = new Boy();
//        boy = null;
        String girlName = getGirlName1(boy);
        System.out.println("girlName = " + girlName);
    }

    public String getGirlName(Boy boy) {
        return boy.getGirl().getName();
    }
    
    @Test
    public void test5(){
        Boy boy = null;
        boy = new Boy();
        boy = new Boy(new Girl("苍老师"));
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

    //使用Optional优化有以后的getGirlName()
    public String getGirlName1(Boy boy) {
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        //此时boy1一定非空
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("迪丽热巴")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        //此时girl1一定非空
        Girl girl1 = girlOptional.orElse(new Girl("古力娜扎"));

        return girl1.getName();

    }
}
