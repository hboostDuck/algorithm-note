package com.orbit.code.thread;

/**
 * @Author: orbit
 * @Date: 2022/09/01/12:10
 * @Description:
 */
public class ThreadPrint1 {
    private static Integer state = 0;

    private static Object lock = new Object();

    private static Integer count = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock){
                    if (count < 100 && state == 0 ){
                        System.out.println(Thread.currentThread()+"A");
                        count++;
                        state = 1;
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (lock){
                    if (count < 100 && state == 1 ){
                        System.out.println(Thread.currentThread()+"B");
                        count++;
                        state = 2;
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        Thread t3 = new Thread(() -> {
            while (true) {
                synchronized (lock){
                    if (count < 100 && state == 2 ){
                        System.out.println(Thread.currentThread()+"C");
                        count++;
                        state = 0;
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
