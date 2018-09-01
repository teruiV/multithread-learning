package chapter2.readWriteLock;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jianweilin
 * @date 2018/9/1
 */
public class ReadWriteList<E> {
    private List<E> list = Lists.newArrayList();
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public ReadWriteList(E ...initElements) {
        list.addAll(Arrays.asList(initElements));
    }

    public void add(E element){
        Lock writeLock = rwLock.writeLock();
        writeLock.lock();
        try {
            list.add(element);
        }finally {
            writeLock.unlock();
        }
    }

    public E get(int index){
        Lock readLock = rwLock.readLock();
        readLock.lock();
        try {
            return list.get(index);
        }finally {
            readLock.unlock();
        }
    }

    public int size(){
        Lock readLock = rwLock.readLock();
        readLock.lock();
        try {
            return list.size();
        }finally {
            readLock.unlock();
        }
    }
}
