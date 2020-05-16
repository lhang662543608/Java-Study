package singleton.type6;

/**
 * 静态内部类
 * 线程安全，效率高
 * 推荐使用
 *
 * @author lhang
 * @create 2020-05-16 10:03
 */
public class Singleton {
    //私有化构造器
    private Singleton() {
    }

    //构建静态内部类，声明并实例化Singleton静态属性
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    //提供一个静态的公有方法，直接返回SingletonInstance.INSTANCE
    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
