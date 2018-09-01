package chapter1.syn;

/**
 * @author jianweilin
 * @date 2018/9/1
 */
public class App {
    public static void main(String[] args) {
        Message msg = new Message("init msg");
        Waiter waiter = new Waiter(msg);
        Notifier notifier = new Notifier(msg);

        new Thread(waiter,"waiter01").start();
        new Thread(waiter,"waiter02").start();
        new Thread(notifier,"notifier01").start();
        new Thread(notifier,"notifier02").start();

        System.out.println("all thread are started");

    }
}
