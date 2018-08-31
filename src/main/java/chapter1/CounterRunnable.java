package chapter1;

import chapter1.domain.SynchronizedCounter;

/**
 * @author jianweilin
 * @date 2018/8/31
 */
public class CounterRunnable implements Runnable{
    private SynchronizedCounter synchronizedCounter;

    public CounterRunnable(SynchronizedCounter synchronizedCounter) {
        this.synchronizedCounter = synchronizedCounter;
    }

    @Override
    public void run() {
        for (int i=0; i< 100; i++){
            synchronizedCounter.increase();
            System.out.println(String.format("ThreadName: %s, value: %d",Thread.currentThread().getName(), synchronizedCounter.getValue()));
        }
    }
}
