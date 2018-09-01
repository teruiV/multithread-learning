package chapter2.readWriteLock;

import java.util.Random;

/**
 * @author jianweilin
 * @date 2018/9/1
 */
public class ReadThread extends Thread {
    private ReadWriteList shareList;

    public ReadThread(ReadWriteList shareList){
        this.shareList = shareList;
    }

    @Override
    public void run() {
        Random random = new Random();
        int index =  random.nextInt(shareList.size());
        System.out.println(String.format("【 read 】name: %s -> get %d index: %d, size: %d",getName(),index,shareList.get(index),shareList.size()));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
