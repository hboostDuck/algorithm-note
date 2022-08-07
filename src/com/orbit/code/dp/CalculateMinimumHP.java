package com.orbit.code.dp;

import java.util.Arrays;

public class CalculateMinimumHP {
    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        if (m == 0) return 0;
        int n = dungeon[0].length;
        if (n == 0) return 0;
        memo = new int[m][n];
        for (int[] ints : memo) {
            Arrays.fill(ints,-1);
        }
        return dp(dungeon,0,0);
    }

    private int dp(int[][] dungeon, int i, int j) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        if (i == m-1 && j == n-1){
            return dungeon[i][j] >= 0 ? 1 : -dungeon[i][j] +1;
        }
        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != -1){
            return memo[i][j];
        }
        int res = Math.min(dp(dungeon, i+1, j),dp(dungeon,i,j+1))-dungeon[i][j];
        memo[i][j] = res <= 0 ? 1 : res;
        return memo[i][j];
    }

    int[][] memo;

    public int calculateMinimumHP1(int[][] dungeon) {

        int m = dungeon.length;
        if (m == 0) return 0;
        int n = dungeon[0].length;
        if (n == 0) return 0;
        int[][] dp = new int[m+1][n+1];

        dp[m-1][n-1] = dungeon[m-1][n-1] >=0 ? 1 : -dungeon[m-1][n-1] +1;

        for (int i = m; i >=0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m || j == n){
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                if (i == m - 1 && j == n - 1) {
                    continue;
                }
                int res = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = res <= 0 ? 1 : res;
            }
        }
        return dp[0][0];
    }
}
