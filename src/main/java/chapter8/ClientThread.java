package chapter8;

import java.util.Random;

/**
 * 委托者,将Request传递给Channel对象
 * @author jianweilin
 * @date 2018/9/9
 */
public class ClientThread implements Runnable {
    private final Channel channel;
    private final Random random;

    public ClientThread(Channel channel) {
        this.channel = channel;
        this.random = new Random();
    }

    @Override
    public void run() {
        try{
            for (int i = 0; true; i++){
                Request request = new Request(Thread.currentThread().getName(),i);
                channel.putRequest(request);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
