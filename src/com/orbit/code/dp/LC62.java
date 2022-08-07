package com.orbit.code.dp;

public class LC62 {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return dp(m-1,n-1);
    }

    private int dp(int d, int r) {
        if (d == 0 &&r == 0){
            return 1;
        }
        if (d < 0 || r < 0){
            return 0;
        }
        if (memo[d][r]  >0){
            return memo[d][r];
        }
        memo[d][r] = dp(d - 1, r) + dp(d, r - 1);
        return memo[d][r];
    }
}
