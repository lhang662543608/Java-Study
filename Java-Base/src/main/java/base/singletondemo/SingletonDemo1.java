package base.singletondemo;

public class SingletonDemo1 {
    private static class SingletonHolder {
        private static final SingletonDemo1 INSTANCE = new SingletonDemo1();
    }

    private SingletonDemo1() {
    }

    public static final SingletonDemo1 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}