package chapter5.pAndC;

import java.util.Random;

/**
 * @author jianweilin
 * @date 2018/9/8
 */
public class MarkerThread extends Thread{
    private final Random random;
    private final Table table;
    private static int id = 0;

    private static synchronized int nextId(){
        return id++;
    }
    public MarkerThread(String name, Table table){
        super(name);
        this.table = table;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(random.nextInt(1000));
                String cake = String.format("[ Cake No. %d by %s]",nextId(), getName());
                table.put(cake);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
