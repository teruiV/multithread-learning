package chapter4;

/**
 * @author jianweilin
 * @date 2018/9/2
 */
public class App {
    public static void main(String[] args) {
        Data data = new Data("data.txt","(empty)");
        new ChangerThread("changerThread",data).start();
        new SaverThread("saverThread",data).start();
    }
}
