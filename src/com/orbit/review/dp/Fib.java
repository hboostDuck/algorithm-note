package com.orbit.review.dp;

public class Fib {

    public int fib(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[n] = dp[n-1]+dp[n-2];
        }
        return dp[n];
    }



}
