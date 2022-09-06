package com.orbit.code.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: orbit
 * @Date: 2022/09/01/13:13
 * @Description:
 */
public class ThreadPrint3 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition a = lock.newCondition();
        Condition b = lock.newCondition();
        Condition c = lock.newCondition();

        Thread t1 = new Thread(new PrintRunner(lock, a, b, 34, 'A'));
        Thread t2 = new Thread(new PrintRunner(lock, b, c, 33, 'B'));
        Thread t3 = new Thread(new PrintRunner(lock, c, a, 33, 'C'));
        t1.start();
        t2.start();
        t3.start();
    }
    static class PrintRunner implements Runnable{
        private ReentrantLock lock;

        private Condition curCondition;

        private Condition nextCondition;

        private Integer count;

        private Character c;

        private Integer index = 0;

        public PrintRunner(ReentrantLock lock, Condition curCondition, Condition nextCondition, Integer count, Character c) {
            this.lock = lock;
            this.curCondition = curCondition;
            this.nextCondition = nextCondition;
            this.count = count;
            this.c = c;
        }

        @Override
        public void run() {
            while (true){
                lock.lock();
                if (index< count){
                    System.out.println(c);
                    index++;
                }
                nextCondition.signal();
                try {
                    curCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.unlock();
            }
        }
    }
}

