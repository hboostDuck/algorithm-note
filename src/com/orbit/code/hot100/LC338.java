package com.orbit.code.hot100;

/**
 * @Author: orbit
 * @Date: 2022/09/01/17:38
 * @Description:
 */
public class LC338 {

    public int[] countBits1(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0){
                res[i] = res[i-1]+1;
            }else {
                res[i] = res[i/2];
            }
        }
        return res;
    }
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int a = i;
            int o = 0;
            while (a!= 0){
                a &= (a-1);
                o++;
            }
            res[i] = o;
        }
        return res;
    }

    public static void main(String[] args) {
        LC338 l = new LC338();
        l.countBits(5);
    }
}
