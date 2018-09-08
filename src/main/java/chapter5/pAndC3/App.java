package chapter5.pAndC3;

import java.util.concurrent.Exchanger;

/**
 * @author jianweilin
 * @date 2018/9/8
 */
public class App {
    public static void main(String[] args) {
        Exchanger<char[]> exchanger = new Exchanger<>();
        char[] producerBuffer = new char[10];
        char[] consumerBuffer = new char[10];
        new ProduerThread(exchanger,producerBuffer,"生产者-1").start();
        new ConsumerThread(exchanger,consumerBuffer,"消费者-1").start();
    }
}
