package chapter8;

/**
 * 从Channel中获取Request对象，并进行工作
 * @author jianweilin
 * @date 2018/9/9
 */
public class WorkerThread extends Thread{
    private final Channel channel;

    public WorkerThread(String name, Channel channel){
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true){
            Request request = channel.takeRequest();
            request.execute();
        }
    }
}
