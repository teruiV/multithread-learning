package chapter5.pAndC2;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author jianweilin
 * @date 2018/9/8
 */
public class Table extends ArrayBlockingQueue<String>{

    public Table(int count){
        super(count);
    }

    @Override
    public void put(String cake) throws InterruptedException {
        System.out.println(String.format("threadName: %s puts %s",Thread.currentThread().getName(),cake));
        super.put(cake);
    }

    @Override
    public String take() throws InterruptedException {
        String cake = super.take();
        System.out.println(String.format("threadName: %s takes %s",Thread.currentThread().getName(),cake));
        return cake;
    }
}
