package chapter1;

/**
 * @author jianweilin
 * @date 2018/8/29
 */
public class App {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        for (int i = 0 ; i < 100; i++){
            System.out.print("GOOD\t");
        }
    }
}
