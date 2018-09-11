package chapter10;

/**
 * @author jianweilin
 * @date 2018/9/11
 */
public class CountupThread extends Thread{
    private long counter = 0;

    private volatile boolean shutdownRequested = false;

    public void shutdownRequest(){
        shutdownRequested = true;
        interrupt();
    }

    public boolean isShutdownRequested(){
        return shutdownRequested;
    }


    @Override
    public void run() {
        try {
            while (!isShutdownRequested()){
                doWork();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            doShutdown();
        }
    }

    private void doWork() throws InterruptedException {
        counter ++;
        System.out.printf("doWork: counter = %d\n",counter);
        Thread.sleep(500);
    }

    private void doShutdown(){
        System.out.printf("doShutdown: counter = %d\n",counter);
    }
}
