package chapter6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jianweilin
 * @date 2018/9/8
 */
public class Data {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public Data(int size){
        this.buffer = new char[size];
        for(int i = 0; i < buffer.length; i ++){
            buffer[i] = '*';
        }
    }

    public char[] read(){
        Lock readLock = lock.readLock();
        readLock.lock();
        try {
            return doRead();
        }finally {
            readLock.unlock();
        }
    }

    public void write(char c){
        Lock writeLock = lock.writeLock();
        // lock 放try外，如果lock发生异常，lock不会执行4finally内的内容也不会执行。
        writeLock.lock();
        try {
            doWrite(c);
        }finally {
            writeLock.unlock();
        }
    }

    private char[] doRead(){
        char[] newBuf = new char[buffer.length];
        for(int i = 0; i < buffer.length; i++){
            newBuf[i] = buffer[i];
        }
        slowly();
        return newBuf;
    }

    private void doWrite(char c){
        for(int i = 0; i < buffer.length; i++){
            buffer[i] = c;
            slowly();
        }
    }

    private void slowly(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
