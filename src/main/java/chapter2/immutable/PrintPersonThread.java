package chapter2.immutable;

import com.alibaba.fastjson.JSON;

/**
 * @author jianweilin
 * @date 2018/9/1
 */
public class PrintPersonThread extends Thread{
    private Person person;

    public PrintPersonThread(Person person){
        this.person = person;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(String.format("threadName:%s, person_info = %s",Thread.currentThread().getName(), JSON.toJSONString(person)));
        }
    }
}
