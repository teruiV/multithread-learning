package chapter3.Demo;

import chapter3.Request;
import chapter3.RequestQueue;

/**
 * @author jianweilin
 * @date 2018/9/1
 */
public class App {
    public static void main(String[] args) {
        RequestQueue r1 = new RequestQueue();
        RequestQueue r2 = new RequestQueue();
        r1.putRequest(new Request("Hello1"));
        new TalkThread(r1,r2,"Lisa").start();
        new TalkThread(r2,r1,"Jane").start();
    }
}
