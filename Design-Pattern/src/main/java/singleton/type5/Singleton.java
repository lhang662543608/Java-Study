package singleton.type5;

/**
 * 懒汉式-线程安全-双重检查
 * 推荐使用
 *
 * @author lhang
 * @create 2020-05-16 9:54
 */
public class Singleton {
    //1.私有化构造器
    private Singleton() {
    }

    //2.在本类内部声明私有的对象实例
    private static Singleton Instance;

    //3.提供一个静态的公有方法,加入双重检查代码，解决线程安全问题，同时解决懒加载问题，保证了效率
    public static synchronized Singleton getInstance() {
        if (Instance == null) {
            synchronized (Singleton.class) {
                if (Instance == null) {
                    Instance = new Singleton();
                }
            }
        }
        return Instance;
    }
}
