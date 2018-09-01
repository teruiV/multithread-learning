package chapter2.readWriteLock;

import java.util.Random;

/**
 * @author jianweilin
 * @date 2018/9/1
 */
public class WriteThread extends Thread {
    private ReadWriteList<Integer> shareList;

    public WriteThread(ReadWriteList shareList){
        this.shareList = shareList;
    }
    @Override
    public void run() {
        Random random = new Random();
        int number = random.nextInt(10);
        shareList.add(number);
        System.out.println(String.format("【 write 】name: %s -> put number: %d, size: %d",getName(),number, shareList.size()));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
