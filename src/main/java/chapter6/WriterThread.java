package chapter6;

import java.util.Random;

/**
 * @author jianweilin
 * @date 2018/9/8
 */
public class WriterThread implements Runnable{
    private final Random random;
    private final Data data;
    private final String filler;
    private int index = 0;

    public WriterThread(Data data, String filler) {
        this.data = data;
        this.filler = filler;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true){
                char c = nextChar();
                data.write(c);
                System.out.printf("%s write %c\n",Thread.currentThread().getName(), c);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() {
        char c = filler.charAt(index);
        index++;
        if(index >= filler.length()){
            index = 0;
        }
        return c;
    }
}
