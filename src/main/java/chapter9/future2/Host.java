package chapter9.future2;

import chapter9.RealData;

import java.util.concurrent.Callable;

/**
 * @author jianweilin
 * @date 2018/9/10
 */
public class Host {
    public FutureData request(final int count,final char c){
        System.out.printf("request(%d,%s)BEGIN\n",count,c);
        FutureData future = new FutureData(new Callable<RealData>() {
            @Override
            public RealData call() throws Exception {
                return new RealData(count,c);
            }
        });

        new Thread(future).start();
        System.out.printf("request(%d,%s)END\n",count,c);
        return future;
    }
}
