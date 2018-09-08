package chapter4.waitTimeout;

/**
 * @author jianweilin
 * @date 2018/9/2
 */
public class App {
    public static void main(String[] args) {
//        Host host = new Host(1000);
//        try {
//            System.out.printf("execute BEGIN");
//            host.execute();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }
//        Thread t = new Thread(() -> System.out.println(">>>>>"));
        while (true){
            new Thread(() -> System.out.println(">>>>>")).start();
        }
    }
}
