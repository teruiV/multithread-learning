package chapter3;

import com.alibaba.fastjson.JSON;

import java.util.Random;

/**
 * @author jianweilin
 * @date 2018/9/1
 */
public class ServerThread extends Thread{
    private final Random random;
    private final RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue, String name){
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            Request request = requestQueue.getRequest();
            System.out.println(String.format("threadName:%s, handle requests: %s", getName(), JSON.toJSONString(request)));
            try {
                Thread.sleep(random.nextInt(20));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
