package chapter8.workerThread2;

import java.util.Random;

/**
 * @author jianweilin
 * @date 2018/9/9
 */
public class Request implements Runnable{
    private final String name;
    private final int number;
    private static final Random random = new Random();

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public void run() {
        System.out.printf("%s executors %s\n", Thread.currentThread().getName(),this);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("[Request from %s No.%d]",name,number);
    }
}
