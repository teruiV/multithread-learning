package chapter5.pAndC3;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * @author jianweilin
 * @date 2018/9/8
 */
public class ConsumerThread extends Thread{
    private final Exchanger<char[]> exchanger;
    private char[] buffer = null;
    private final Random random;
    public ConsumerThread(Exchanger<char[]> exchanger,char[] buffer,String name){
        super(name);
        this.exchanger = exchanger;
        this.buffer = buffer;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.printf("%s before exchange \n",getName());
                buffer = exchanger.exchange(buffer);
                System.out.printf("%s after exchange \n",getName());

                // 从缓存区取出字符
                for (int i = 0 ; i < buffer.length ; i++){
                    System.out.printf("%s -> %s \n",getName(),buffer[i]);
                    Thread.sleep(random.nextInt(1000));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
