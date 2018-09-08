package chapter4.join;

/**
 * @author jianweilin
 * @date 2018/9/3
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new JoinDemo(),"join-demo");
        t.start();
        t.join();

        for (int i = 0; i < 100; i++){
            System.out.println(String.format("ThreadName: %s, value: %d", Thread.currentThread().getName(),i));
        }

    }
}
