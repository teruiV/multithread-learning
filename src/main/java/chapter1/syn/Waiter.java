package chapter1.syn;

/**
 * @author jianweilin
 * @date 2018/9/1
 */
public class Waiter implements Runnable{
    private Message msg;

    public Waiter(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        synchronized (msg){
            try{
                System.out.println(String.format("【 wait 】name: %s, waiting to get notify at time: %d",threadName, System.currentTimeMillis()));
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("【 get notify 】name: %s, waitier thread get notify at time: %d",threadName, System.currentTimeMillis()));
            System.out.println(String.format("【 print msg 】name:%s process msg: %s",threadName,msg.getMgs()));
        }
    }
}
