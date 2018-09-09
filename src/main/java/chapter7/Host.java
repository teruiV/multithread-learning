package chapter7;

/**
 * @author jianweilin
 * @date 2018/9/9
 */
public class Host {
    private final Helper helper = new Helper();

    public void request(final int count, final char c){
        System.out.printf("request (%d, %s) BEGIN \n",count,c);
        new Thread(() -> {
            helper.handle(count,c);
        }).start();
        System.out.printf("request (%d, %s) END \n",count,c);
    }
}
