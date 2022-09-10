package com.orbit.code.offer1;

/**
 * @Author: orbit
 * @Date: 2022/09/10/20:19
 * @Description:
 */
public class LC66 {
    public int[] constructArr(int[] a) {
        int n = a.length;
        if (n == 0) return new int[0];
        int[] prefix = new int[n];
        prefix[0] = a[0];
        for (int i = 1; i <n; i++) {
            prefix[i] = prefix[i-1]* a[i];
        }
        int[] suffix = new int[n];
        suffix[n-1] = a[n-1];
        for (int i = n-2; i >=0; i--) {
            suffix[i] = suffix[i+1] * a[i];
        }
        int[] res = new int[n];
        res[0] = suffix[1];
        res[n-1] = prefix[n-2];
        for (int i = 1; i < n-1; i++) {
            res[i] = prefix[i-1] * suffix[i+1];
        }
        return res;
    }
}
