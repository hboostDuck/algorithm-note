package com.orbit.code.hot100;

/**
 * @Author: orbit
 * @Date: 2022/09/12/11:52
 * @Description:
 */
public class LC312 {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] coin = new int[n + 2];
        coin[0] = coin[n+1] = 1;
        for (int i = 1; i < n + 1; i++) {
            coin[i] = nums[i-1];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >=0; i--) {
            for (int j = i+1; j <n+2; j++) {
                for (int k = i+1; k <j; k++) {
                    dp[i][j] = Math.max(dp[i][j],dp[i][k] + dp[k][j] + coin[k]*coin[i] * coin[j]);
                }
            }
        }
        return dp[0][n+1];
    }


}
