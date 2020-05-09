package base.thread;

/**
 * 输出100以内的偶数
 */
//1.继承Thread类
public class MyThread1 extends Thread {
    //重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if ((i & 1) == 0) {
                System.out.println(Thread.currentThread().getName()+":" + i);
            }

        }
    }
}
