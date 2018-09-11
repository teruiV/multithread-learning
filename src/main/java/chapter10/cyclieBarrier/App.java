package chapter10.cyclieBarrier;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jianweilin
 * @date 2018/9/11
 */
public class App {
    private static final int THREADS = 3;
    public static void main(String[] args) {
        System.out.println("BEGIN");

        ExecutorService service = Executors.newFixedThreadPool(THREADS);

        // 屏障被解除时的操作
        Runnable barrierAction = () -> System.out.println("Barrier action");

        // cyclieBarrier用于使线程步调一致
        CyclicBarrier phaseBarrier = new CyclicBarrier(THREADS, barrierAction);

        // countdownlatch 用于确认工作是否结束
        CountDownLatch donwLatch = new CountDownLatch(THREADS);

        try {
            // 开始工作
            for (int t = 0 ; t < THREADS; t++){
                service.execute(new MyTask(phaseBarrier,donwLatch,t));
            }
            System.out.println("AWAIT");
            donwLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            service.shutdown();
            System.out.println("END");
        }

    }
}
