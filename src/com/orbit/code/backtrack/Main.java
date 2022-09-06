package com.orbit.code.backtrack;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("runnig");

        });

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t1.interrupt();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(t1.isInterrupted());
    }

}
