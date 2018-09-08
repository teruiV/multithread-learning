package chapter5.pAndC;

/**
 * 消费者和生产者样例1
 * @author jianweilin
 * @date 2018/9/8
 */
public class App {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.printf("start: %d\n",start);

        Table table = new Table(3);
        new MarkerThread("蛋糕师-1",table).start();
        new MarkerThread("蛋糕师-2",table).start();
        new MarkerThread("蛋糕师-3",table).start();
        new EaterThread("顾客-1",table).start();
        new EaterThread("顾客-2",table).start();
        new EaterThread("顾客-3",table).start();
    }
}
