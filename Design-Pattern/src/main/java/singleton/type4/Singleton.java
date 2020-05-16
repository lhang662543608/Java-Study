package singleton.type4;

/**
 * 懒汉式-线程安全-同步方法
 * 不推荐使用(效率低)
 *
 * @author lhang
 * @create 2020-05-16 9:40
 */
public class Singleton {
    //1.私有化构造器
    private Singleton() {
    }

    //2.在本类内部声明私有的对象实例
    private static Singleton Instance;

    //3.提供一个静态的公有方法
    public static synchronized Singleton getInstance() {
        if (Instance == null) {
            Instance = new Singleton();
        }
        return Instance;
    }
}
