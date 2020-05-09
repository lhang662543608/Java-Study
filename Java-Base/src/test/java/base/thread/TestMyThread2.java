package base.thread;

import org.junit.Test;

public class TestMyThread2 {
    @Test
    public void testMyThread() throws InterruptedException {
        MyThread2 thread2 = new MyThread2();
        Thread thread = new Thread(thread2);
        thread.setName("线程1");
        thread.start();//①启动线程②调用当前线程的run方法

        Thread thread1 = new Thread(thread2);
        thread1.setName("线程2");
        thread1.start();//①启动线程②调用当前线程的run方法

        thread.join();
        thread1.join();
    }
}
