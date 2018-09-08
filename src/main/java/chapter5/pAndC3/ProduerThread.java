package chapter5.pAndC3;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * @author jianweilin
 * @date 2018/9/8
 */
public class ProduerThread extends Thread{
    private final Exchanger<char []> exchanger;
    private char[] buffer = null;
    private char index = 0;
    private final Random random;

    public ProduerThread(Exchanger<char []> exchanger, char[] buffers,String name){
        super(name);
        this.exchanger = exchanger;
        this.buffer = buffers;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true){
                for (int i =0; i < buffer.length ; i++){
                    buffer[i] = nextChar();
                    System.out.printf("%s, %s -> \n",getName(),buffer[i]);
                    System.out.printf("%s before exchange \n",getName());
                    buffer = exchanger.exchange(buffer);
                    System.out.printf("%s after exchange \n",getName());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() throws InterruptedException {
        char c = (char)('A' + index % 26);
        index ++;
        Thread.sleep(random.nextInt(1000));
        return c;
    }
}
