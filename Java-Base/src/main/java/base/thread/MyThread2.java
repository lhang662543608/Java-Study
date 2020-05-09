package base.thread;

/**
 * 1.实现Runnable接口
 * 2.重写接口的run方法
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递给Thread类的构造器，创建Thread类的对象
 * 5.通过Thread对象调用start()方法。
 */
public class MyThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if ((i&1)==0){
                System.out.println(Thread.currentThread().getName()+"--"+i);
            }
        }
    }
}
