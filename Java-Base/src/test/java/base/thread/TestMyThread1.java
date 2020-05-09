package base.thread;

import org.junit.Test;

public class TestMyThread1 {
    @Test
    public void testMyThread() throws InterruptedException {
        //3.创建Mythread对象
        MyThread1 myThread1 = new MyThread1();
        //4.调用start方法，启动线程，使线程变为就绪状态
        myThread1.start();
        //Thread.yield();//释放当前cpu的执行权

    }
}
