package chapter9.future2;

import chapter9.Data;

/**
 * @author jianweilin
 * @date 2018/9/10
 */
public class App {
    public static void main(String[] args) {
        System.out.println("MAIN BEGIN");
        Host host = new Host();
        Data d1 = host.request(10,'A');
        Data d2 = host.request(20,'B');
        Data d3 = host.request(30,'C');

        System.out.println("Main other job begin");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main other job END");

        System.out.printf("data1 = %s\n",d1.getContent());
        System.out.printf("data2 = %s\n",d2.getContent());
        System.out.printf("data3 = %s\n",d3.getContent());
        System.out.println("MAIN END");
    }
}
