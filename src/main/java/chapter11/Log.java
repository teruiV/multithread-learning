package chapter11;

/**
 * @author jianweilin
 * @date 2018/9/12
 */
public class Log {
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<>();

    public static void println(String s){
        getTSLong().println(s);
    }

    public static void close(){
        getTSLong().close();
    }
    private static TSLog getTSLong(){
        TSLog tsLog = tsLogCollection.get();

        // 如果该线程是第一次调用本方法，就新生成并注册一个日志
        if(tsLog == null){
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }
        return tsLog;
    }
}
