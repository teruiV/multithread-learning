package chapter5.pAndC;

/**
 * @author jianweilin
 * @date 2018/9/8
 */
public class Table {
    private final String[] buffer;
    private int tail;
    private int head;
    private int count;

    public Table(int count) {
        this.count = 0;
        this.head = 0;
        this.tail = 0;
        this.buffer = new String[count];
    }

    /**
     * 放置蛋糕
     * @param cake
     */
    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(String.format("threadName: %s puts %s",Thread.currentThread().getName(),cake));
        while (count >= buffer.length){
            wait();
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count ++;
        notifyAll();
    }

    /**
     * 拿取蛋糕
     * @return
     * @throws InterruptedException
     */
    public synchronized String take() throws InterruptedException {
        while (count <= 0){
            wait();
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count --;
        notifyAll();
        System.out.println(String.format("threadName: %s takes %s",Thread.currentThread().getName(),cake));
        return cake;
    }
}
