package chapter4.waitTimeout;

import java.util.concurrent.TimeoutException;

/**
 * @author jianweilin
 * @date 2018/9/2
 */
public class Host {
    /**
     * 超时时间
     */
    private final long timeout;

    /**
     * 方法正常执行时值为false
     */
    private boolean ready = false;

    public Host(long timeout) {
        this.timeout = timeout;
    }

    /**
     * 修改状态
     * @param on
     */
    public synchronized void setExecutable(boolean on){
        ready = on;
        notifyAll();
    }

    /**
     * 检查状态之后再执行
     * @throws TimeoutException
     * @throws InterruptedException
     */
    public synchronized void execute() throws TimeoutException, InterruptedException {
        long start = System.currentTimeMillis();
        while (!ready){
            long now = System.currentTimeMillis();
            long rest = timeout - (now - start);
            if(rest < 0){
                throw new TimeoutException(String.format("now - start = %d, timeout = %d",(now -start), timeout));
            }
            wait(rest);
        }
        doExecute();
    }

    /**
     * 实际的处理
     */
    private void doExecute(){
        System.out.println(String.format("threadName: %s calls doExecute",Thread.currentThread().getName()));
    }
}
