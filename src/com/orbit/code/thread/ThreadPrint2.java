package com.orbit.code.thread;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: orbit
 * @Date: 2022/09/01/12:37
 * @Description:
 */
public class ThreadPrint2 {

    private static ReentrantLock lock = new ReentrantLock();

    private static Integer count = 0;
    public static void main(String[] args) {
        Condition a = lock.newCondition();
        Condition b = lock.newCondition();
        Condition c = lock.newCondition();
        Thread t1 = new Thread(() -> {
            while (true) {
                lock.lock();
                if (count < 100){
                    System.out.println(Thread.currentThread()+"A");
                    count++;
                    b.signal();
                    try {
                        a.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
//                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                lock.lock();
                if (count < 100){
                    System.out.println(Thread.currentThread()+"B");
                    count++;
                    c.signal();
                    try {
                        b.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
//                lock.unlock();
            }
        });
        Thread t3 = new Thread(() -> {
            while (true) {
                lock.lock();
                if (count < 100){
                    System.out.println(Thread.currentThread()+"C");
                    count++;
                    a.signal();
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
//                lock.unlock();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

}
