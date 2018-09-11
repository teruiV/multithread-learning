package chapter10.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jianweilin
 * @date 2018/9/11
 */
public class App {
    private static final int TASKS = 10; // 工作的个数

    public static void main(String[] args) {
        System.out.println("BEGIN");
        ExecutorService service = Executors.newFixedThreadPool(5);
        CountDownLatch doneLatch = new CountDownLatch(TASKS);
        try{
            for (int t = 0; t < TASKS; t++){
                service.execute(new MyTask(doneLatch, t));
            }
            System.out.println("AWAIT");
            doneLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            service.shutdown();
            System.out.println("END");
        }
    }
}
