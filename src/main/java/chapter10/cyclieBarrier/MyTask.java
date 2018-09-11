package chapter10.cyclieBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author jianweilin
 * @date 2018/9/11
 */
public class MyTask implements Runnable {
    private static final int PHASE = 5;
    private final CyclicBarrier phaseBarrier;
    private final CountDownLatch downLatch;
    private final int context;
    private static final Random random = new Random();

    public MyTask(CyclicBarrier phaseBarrier, CountDownLatch downLatch, int context) {
        this.phaseBarrier = phaseBarrier;
        this.downLatch = downLatch;
        this.context = context;
    }

    @Override
    public void run() {
        try {
            for (int phase = 0; phase < PHASE; phase ++ ){
                doPhase(phase);
                phaseBarrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }finally {
            downLatch.countDown();
        }
    }

    protected void doPhase(int phase){
        String name = Thread.currentThread().getName();
        System.out.printf("name: %s mytask begin context: %s\n",name,context);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.printf("name: %s mytask end context: %s\n",name,context);
        }

    }
}
