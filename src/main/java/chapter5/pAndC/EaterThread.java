package chapter5.pAndC;

import java.util.Random;

/**
 * @author jianweilin
 * @date 2018/9/8
 */
public class EaterThread extends Thread{
    private final Random random;
    private final Table table;

    public EaterThread(String name, Table table){
        super(name);
        this.table = table;
        this.random = new Random();
    }

    @Override
    public void run() {
       try{
           while (true){
               String cake = table.take();
               Thread.sleep(random.nextInt(1000));
           }
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }
}
