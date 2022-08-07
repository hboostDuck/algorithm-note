package com.orbit.code.test;


/**
 * @author hxy
 * @create 2022-03-04 18:23
 */

public class Solution {

    static  ThreadLocal<Object>  obj = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        obj.set(new String("aaa"));
//        o.wait();
//        o.notify();
        System.out.println(111);
    }
    static  Object o = new Object();
    public int getLongestPalindrome (String A) throws InterruptedException {
        // write code here
        if (A == null || A.length() == 0) {
            return 0;
        }
        int strLen = A.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart=0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left>=0 && A.charAt(left) == A.charAt(i)){
                len++;
                left--;
            }
            while (right < strLen && A.charAt(right) == A.charAt(i)){
                len++;
                right++;
            }

        }
        return 1;
    }
}


class Main{
    public static void main(String[] args) {
//        boolean flag = true;
//        final ReentrantLock lock = new ReentrantLock();
//        final Condition condition = lock.newCondition();
//        final Thread t1 = new Thread(() -> {
//            for (int i = 1; i <= 100; i += 2) {
////                try {
////                    condition.await();
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//
//            }
//        }, "t1");
//        final Thread t2 = new Thread(() -> {
//            for (int i = 2; i <= 100; i += 2) {
//
//                System.out.println(i);
//            }
//        }, "t2");
//        t1.start();
//        t2.start();

        final boolean[] flag = {true};
        new Thread(()-> {
            synchronized (Main.class){
            if (flag[0]){
            for (int i = 1; i <= 100; i++) {
                        System.out.println(Thread.currentThread().getName()+i);
                }
            flag[0] =false;
            }
            }
        },"t1").start();
        new Thread(()-> {
            synchronized (Main.class){
            for (int i = 2; i <= 100; i++) {

                    if (!flag[0]){
                        System.out.println(Thread.currentThread().getName()+i);
                        flag[0] =true;
                    }
                }

            }
        },"t2").start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Lock1{
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(()-> {
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName()+"拿到了lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("...");
                }
            }
        },"t1").start();

        new Thread(() -> {
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName()+"拿到了lock2锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("...");
                }
            }
        },"t2").start();
    }


}