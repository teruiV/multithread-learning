package chapter9;

/**
 * @author jianweilin
 * @date 2018/9/10
 */
public class Host {
    public Data request(final int count, final char c){
        System.out.printf("request(%d,%s) BEGIN\n",count,c);

        final FutureData future = new FutureData();
        new Thread(() -> {
            RealData realData = new RealData(count,c);
            future.setRealData(realData);
        }).start();

        System.out.printf("request(%d,%s) END\n",count,c);
        return future;
    }
}
