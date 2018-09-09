package chapter8;

/**
 * @author jianweilin
 * @date 2018/9/9
 */
public class App {
    public static void main(String[] args) {
        Channel channel = new Channel(5);
        channel.startWorkers();
        new Thread(new ClientThread(channel),"客户-1").start();
        new Thread(new ClientThread(channel),"客户-2").start();
        new Thread(new ClientThread(channel),"客户-3").start();
    }
}
