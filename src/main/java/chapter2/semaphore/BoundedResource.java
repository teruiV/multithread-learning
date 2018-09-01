package chapter2.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author jianweilin
 * @date 2018/9/1
 */
public class BoundedResource {
    private final Semaphore semaphore;

    private final int permits;

    private final static Random random = new Random(314159);

    public BoundedResource(int permits) {
        this.permits = permits;
        this.semaphore = new Semaphore(permits);
    }

    public void use() throws InterruptedException {
        semaphore.acquire();
        try {
            doUse();
        }finally {
            semaphore.release();
        }
    }

    protected void doUse() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("name: %s, BEGIN: used = %d",threadName, (permits - semaphore.availablePermits())));
        Thread.sleep(500);
        System.out.println(String.format("name: %s, END: used = %d",threadName, (permits - semaphore.availablePermits())));
    }
}
