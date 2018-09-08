package chapter6;

/**
 * @author jianweilin
 * @date 2018/9/8
 */
public class App {
    public static void main(String[] args) {
        Data data = new Data(5);
        Runnable r = new ReaderThread(data);
        Runnable w = new WriterThread(data,"abc");
        new Thread(r,"read thread").start();
        new Thread(w,"write thread").start();
    }
}
