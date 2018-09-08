package chapter4.join;

/**
 * @author jianweilin
 * @date 2018/9/3
 */
public class JoinDemo implements Runnable{

    @Override
    public void run() {
        for (int i = 0;i < 100; i ++){
            System.out.println(String.format(">>>>>>>>ThreadName: %s join demo values: %d >>>>>>",Thread.currentThread().getName(),i));
        }
    }
}
