package chapter1.thread;

/**
 * @author jianweilin
 * @date 2018/8/29
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        for(int i =0; i < 100; i++){
            System.out.print("NICE\t");
        }
    }
}
