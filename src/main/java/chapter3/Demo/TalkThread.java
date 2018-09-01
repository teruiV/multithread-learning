package chapter3.Demo;

import chapter3.Request;
import chapter3.RequestQueue;
import com.alibaba.fastjson.JSON;

/**
 * @author jianweilin
 * @date 2018/9/1
 */
public class TalkThread extends Thread{
    private final RequestQueue input;
    private final RequestQueue output;

    public TalkThread(RequestQueue input,RequestQueue output,String name){
        super(name);
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        System.out.println(String.format("threadName: %s START",Thread.currentThread().getName()));
        for(int i=0; i < 20; i++){
            Request request = input.getRequest();
            System.out.println(String.format("threadName: %s get requests: %s" ,getName(), JSON.toJSONString(request)));

            Request request2 = new Request(request.getName() + "!");
            System.out.println(String.format("threadName: %s put requests: %s" ,getName(), JSON.toJSONString(request2)));
            output.putRequest(request2);
        }
        System.out.println(String.format("threadName: %s END",Thread.currentThread().getName()));
    }
}
