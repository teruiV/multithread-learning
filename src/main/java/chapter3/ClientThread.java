package chapter3;

import com.alibaba.fastjson.JSON;

import java.util.Random;

/**
 * @author jianweilin
 * @date 2018/9/1
 */
public class ClientThread extends Thread{
    private final Random random;
    private final RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue, String name){
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i=0; i < 100; i ++){
            Request request = new Request("NO." + i);
            System.out.println(String.format("threadName: %s, request: %s",Thread.currentThread().getName(), JSON.toJSONString(request)));
            requestQueue.putRequest(request);
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
