package chapter10.defaultHandler;

/**
 * @author jianweilin
 * @date 2018/9/11
 */
public class App {
    public static void main(String[] args) {
        System.out.println("main:BEGIN");

        Thread.setDefaultUncaughtExceptionHandler(
                // 设置为捕获的异常处理器
                new Thread.UncaughtExceptionHandler(){

                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println("****");
                        System.out.println("UncaughtExceptionHandler BEGIN");
                        System.out.println("currentThread = " + Thread.currentThread());
                        System.out.println("thread = " + t);
                        System.out.println("exception = " + e);
                        System.out.println("UncaughtExceptionHandler END");
                    }
                });

        // 设置退出钩子
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
             System.out.println("****");
            System.out.println("ShutdownHook BEGIN");
            System.out.println("currentThread = " + Thread.currentThread());
            System.out.println("ShutdownHook END");
        }));

        new Thread("thread-t"){

            @Override
            public void run() {
                System.out.println("thread-t:begin");
                System.out.println("mythread:sleep...");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread-t:divide");

                int x = 1/ 0;
                System.out.println("thread-t:END");
            }
        }.start();
        System.out.println("MAIN END");
    }
}
