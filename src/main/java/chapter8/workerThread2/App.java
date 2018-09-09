package chapter8.workerThread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @date 2018/9/9
 * @author jianweilin
 */
public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            new ClientThread("客户-1",executorService).start();
            new ClientThread("客户-2",executorService).start();
            new ClientThread("客户-3",executorService).start();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }
}
