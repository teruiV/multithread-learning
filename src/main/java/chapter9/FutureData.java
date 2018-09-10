package chapter9;

/**
 * @author jianweilin
 * @date 2018/9/10
 */
public class FutureData implements Data{
    private RealData realData = null;
    private boolean ready = false;

    public synchronized void setRealData(RealData realData){
        if(ready){
            return;
        }
        this.realData = realData;
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized String getContent() {
        while (!ready){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getContent();
    }
}
