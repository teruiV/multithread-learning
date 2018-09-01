package chapter1.syn;

/**
 * @author jianweilin
 * @date 2018/9/1
 */
public class Notifier implements Runnable {
    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("【 start notify 】notifier thread: %s start at time: %d",threadName,System.currentTimeMillis()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (msg) {
            System.out.println(String.format("【 do nitify 】at time: %d",System.currentTimeMillis()));
            msg.setMgs(String.format("Notifier woker done at time: %d",System.currentTimeMillis()));
            msg.notify();
        }
    }
}
