package chapter4;

import java.io.IOException;
import java.util.Random;

/**
 * @author jianweilin
 * @date 2018/9/2
 */
public class ChangerThread extends Thread{
    private final Data data;
    private final Random random = new Random();

    public ChangerThread(String name,Data data){
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
       try {
           for (int i=0; true; i++){
               data.change(String.format("NO.%d ", i ));
               Thread.sleep(random.nextInt(1000));
               data.save();
           }
       } catch (InterruptedException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
