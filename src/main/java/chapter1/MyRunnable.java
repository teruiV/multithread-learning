package chapter1;

/**
 * @author jianweilin
 * @date 2018/8/30
 */
public class MyRunnable implements Runnable{
    private String msg;

    public MyRunnable(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0;i < 100; i++){
            System.out.println(String.format("Thread Name: %s, msg: %s",Thread.currentThread().getName(),msg));
        }
    }
}
