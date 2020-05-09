package base.singletondemo;

public class SingletonDemo2 {
    //volatile保证，当uniqueInstance变量被初始化成Singleton实例时，多个线程可以正确处理uniqueInstance变量
    private volatile static SingletonDemo2 uniqueInstance;

    private SingletonDemo2() {
    }

    public static SingletonDemo2 getInstance() {
        //检查实例，如果不存在，就进入同步代码块
        if (uniqueInstance == null) {
        //只有第一次才彻底执行这里的代码
            synchronized (SingletonDemo2.class) {
                //进入同步代码块后，再检查一次，如果仍是null，才创建实例
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonDemo2();
                }
            }
        }
        return uniqueInstance;
    }
}