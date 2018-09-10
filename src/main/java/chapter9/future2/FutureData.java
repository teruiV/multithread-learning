package chapter9.future2;

import chapter9.Data;
import chapter9.RealData;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author jianweilin
 * @date 2018/9/10
 */
public class FutureData extends FutureTask<RealData> implements Data{

    public FutureData(Callable<RealData> callable) {
        super(callable);
    }

    @Override
    public String getContent() {
        String str = null;
        try {
            str = get().getContent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return str;
    }
}
