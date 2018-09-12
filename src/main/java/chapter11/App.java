package chapter11;

/**
 * @author jianweilin
 * @date 2018/9/12
 */
public class App {
    public static void main(String[] args) {
        new ClientThread("线程-A").start();
        new ClientThread("线程-B").start();
        new ClientThread("线程-C").start();
    }
}
