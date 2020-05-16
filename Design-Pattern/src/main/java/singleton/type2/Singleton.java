package singleton.type2;

/**
 * 饿汉式-静态代码块
 *
 * @author lhang
 * @create 2020-05-16 8:42
 */
public class Singleton {
    //1.私有化构造器
    private Singleton() {
    }

    //2.在本类内部声明私有的对象实例
    private static final Singleton Instance;

    static {//在静态代码块中创建单例对象。
        Instance = new Singleton();
    }

    //3.提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return Instance;
    }
}
