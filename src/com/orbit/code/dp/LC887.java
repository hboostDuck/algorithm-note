package com.orbit.code.dp;

import java.util.Arrays;

/**
 * @Author: orbit
 * @Date: 2022/09/06/22:20
 * @Description:
 */
public class LC887 {
    int[][] memo;
    public int superEggDrop(int k, int n) {
        memo = new int[k+1][n+1];
        for (int[] ints : memo) {
            Arrays.fill(ints,-666);
        }
        return dp(k,n);
    }

    private int dp(int k, int n) {
        if (k == 1) return n;
        if (n == 0) return 0;
        if (memo[k][n] != -666){
            return memo[k][n];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.min(
                    res,
                    Math.max(dp(k-1,i-1),dp(k,n-i))+1
            );
        }
        memo[k][n] = res;
        return res;
    }
}
