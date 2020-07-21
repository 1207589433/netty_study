package lhc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author arron lu
 * @version 1.0
 * @date 2020/7/21 09:51
 */
public class Reentrant {
    public static void main(String[] args) {

        ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
        lock.writeLock().lock();
    }
}
