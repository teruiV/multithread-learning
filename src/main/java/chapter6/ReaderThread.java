package chapter6;


/**
 * @author jianweilin
 * @date 2018/9/8
 */
public class ReaderThread implements Runnable {
    private final Data data;

    public ReaderThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            char[] readBuf = data.read();
            System.out.printf("%s reads %s\n", Thread.currentThread().getName(), String.valueOf(readBuf));
        }
    }
}
