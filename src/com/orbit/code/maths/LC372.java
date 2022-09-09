package com.orbit.code.maths;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: orbit
 * @Date: 2022/09/07/18:09
 * @Description:
 */
public class LC372 {
    public int superPow(int a, int[] b) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : b) {
            list.addLast(i);
        }
        return sPow(a,list);
    }

    private int sPow(int a, LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return 1;
        }
        Integer n = list.pollLast();
        int p1 = mypow(a,n);
        int p2 = mypow(sPow(a,list),10);
        return (p1*p2)%1337;
    }

    int mypow(int a , int  k){
        if (k == 0) return 1;
        a%=1337;
        if (k % 2 ==1){
            return mypow(a,k-1)*a%1337;
        }else {
            int s = mypow(a,k/2);
            return s*s%1337;
        }
    }
}
