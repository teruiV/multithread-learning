package chapter10.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author jianweilin
 * @date 2018/9/11
 */
public class MyTask implements Runnable{
    private final CountDownLatch doneLatch;
    private final int context;
    private static final Random random = new Random();

    public MyTask(CountDownLatch doneLatch, int context) {
        this.doneLatch = doneLatch;
        this.context = context;
    }

    @Override
    public void run() {
        doTask();
        doneLatch.countDown();
    }

    protected void doTask(){
        String name = Thread.currentThread().getName();
        System.out.printf("name : %s : MyTask: begin content = %s\n",name,context);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.printf("name : %s : MyTask: end content = %s\n",name,context);
        }
    }
}
