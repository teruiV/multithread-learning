package chapter2.readWriteLock;

/**
 * @author jianweilin
 * @date 2018/9/1
 */
public class App {
    public static void main(String[] args) {
        Integer[] initialElements = {33, 28, 86, 99};
        ReadWriteList<Integer> list = new ReadWriteList<>(initialElements);

        for(int i=0; i< 10;i++){
            new ReadThread(list).start();
        }

        for(int i=0; i< 2;i++){
            new WriteThread(list).start();
        }
    }
}
