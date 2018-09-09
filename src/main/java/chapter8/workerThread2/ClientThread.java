package chapter8.workerThread2;


import java.util.Random;
import java.util.concurrent.ExecutorService;

/**
 * @author jianweilin
 * @date 2018/9/9
 */
public class ClientThread extends Thread{
    private final ExecutorService executorService;
    private static final Random random = new Random();

    public ClientThread(String name,ExecutorService executorService){
        super(name);
        this.executorService = executorService;
    }

    @Override
    public void run() {
        try{
            for(int i=0; true;i++){
                Request request = new Request(getName(),i);
                executorService.execute(request);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
