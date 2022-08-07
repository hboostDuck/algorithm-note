package com.orbit.code.difference;

public class CarPooling1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        for (int[] trip : trips) {
            // 乘客数量
            int val = trip[0];
            // 第 trip[1] 站乘客上车
            int i = trip[1];
            // 第 trip[2] 站乘客已经下车，
            // 即乘客在车上的区间是 [trip[1], trip[2] - 1]
            int j = trip[2] - 1;
            arr[i] += val;
            if (j+1 <arr.length){
                arr[j+1] -= val;
            }
        }

        int[] ans = new int[arr.length];
        ans[0] = arr[0];
        if (ans[0]>capacity)return false;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = arr[i]+ans[i-1];
            if (ans[i]>capacity)return false;
        }
        return true;
    }
}
