package com.orbit.code.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Main1 {

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        AtomicInteger init = new AtomicInteger(scanner.nextInt());
//        int count = scanner.nextInt();
//        Map<Integer,Integer> map = new TreeMap<>();
//        int[] pos = new int[count];
//        int[] power = new int[count];
//        for (int i = 0; i < count; i++) {
//            pos[i] = scanner.nextInt();
//        }
//        for (int i = 0; i < count; i++) {
//            power[i] =scanner.nextInt() ;
//        }
//        for (int i = 0; i < count; i++) {
//            map.put(pos[i],power[i]);
//        }
//       map.forEach((k,v) -> {
//          if (init.get() >= k){
//              init.addAndGet(v);
//          }
//       });
//        System.out.println(init.get());
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coupon = scanner.nextInt();
        int dishes = scanner.nextInt();
        int money = scanner.nextInt();
        Map<Integer,Integer> couponMap = new HashMap<>();
        Map<Integer,Integer> dishMap = new HashMap<>();
        for (int i = 0; i < coupon; i++) {
            int xi = scanner.nextInt();
            int yi = scanner.nextInt();
            couponMap.put(xi,yi);
        }
        for (int i = 0; i < dishes; i++) {
            int ai = scanner.nextInt();
            int bi = scanner.nextInt();
            dishMap.put(ai,bi);
        }



    }
}
