package chapter1;

import chapter1.domain.SynchronizedCounter;
import chapter1.thread.CounterRunnable;
import chapter1.thread.MyRunnable;
import chapter1.thread.MyThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author jianweilin
 * @date 2018/8/29
 */
public class App {
    public static void theadMehtod1(){
        MyThread t = new MyThread();
        t.start();
        for (int i = 0 ; i < 100; i++){
            System.out.print("GOOD\t");
        }
    }

    public static void threadMethod2(){
        new Thread(new MyRunnable("GOOD")).start();
        new Thread(new MyRunnable("Night")).start();
    }

    public static void threadMethod3(){
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadFactory.newThread(new MyRunnable("default thread factory")).start();
    }

    public static void syschronizedExample(){
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        new Thread(new CounterRunnable(synchronizedCounter)).start();
        new Thread(new CounterRunnable(synchronizedCounter)).start();

    }
    public static void main(String[] args) throws InterruptedException {
        syschronizedExample();
        threadMethod3();

    }
}
