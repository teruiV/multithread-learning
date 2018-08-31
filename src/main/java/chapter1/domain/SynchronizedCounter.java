package chapter1.domain;

/**
 * @author jianweilin
 * @date 2018/8/31
 */
public class SynchronizedCounter {
    private int c;

    public synchronized void increase(){
        c++;
    }

    public synchronized void decrement(){
        c--;
    }

    public synchronized int getValue(){
        return c;
    }
}
