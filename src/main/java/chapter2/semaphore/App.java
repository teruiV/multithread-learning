package chapter2.semaphore;

import chapter2.UserThread;

/**
 * @author jianweilin
 * @date 2018/9/1
 */
public class App {
    public static void main(String[] args) {
        BoundedResource resource = new BoundedResource(3);
        for (int i = 0; i< 10; i++){
            new UserThread(resource).start();
        }
    }
}
