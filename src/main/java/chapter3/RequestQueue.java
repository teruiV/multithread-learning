package chapter3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianweilin
 * @date 2018/9/1
 */
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<Request>();

    public synchronized Request getRequest(){
        while (queue.peek() == null){
            try {
                wait();
            }catch (InterruptedException e){}
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request){
        queue.offer(request);
        notifyAll();
    }
}
