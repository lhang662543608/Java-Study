package singleton.type1;

/**
 * 饿汉式-静态常量
 *
 * @author lhang
 * @create 2020-05-16 8:35
 */
public class Singleton {
    //1.私有化构造器
    private Singleton() {
    }

    //2.私有化对象实例
    private final static Singleton instance = new Singleton();

    //3.提供一个公有的静态方法，返回实例对象。
    public static Singleton getInstance() {
        return instance;
    }
}
