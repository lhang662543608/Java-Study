package singleton.type3;

/**
 * 懒汉式-线程不安全
 *
 * @author lhang
 * @create 2020-05-16 8:52
 */
public class Singleton {
    //1.私有化构造器
    private Singleton() {
    }

    //2.在本类内部声明私有的对象实例
    private static Singleton Instance;

    //3.提供一个静态的公有方法
    public static Singleton getInstance() {
        if (Instance == null) {
            Instance = new Singleton();
        }
        return Instance;
    }


}
