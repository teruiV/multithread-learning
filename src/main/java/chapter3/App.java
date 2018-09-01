package chapter3;

/**
 * TODO 这章练习题非常有含金量，后续将内容整理为博客。
 * @author jianweilin
 * @date 2018/9/1
 */
public class App {

    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue,"client-thread").start();
        new ServerThread(requestQueue,"server-thread").start();
    }
}
