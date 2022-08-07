package com.orbit.code.dp;



public class MinPathSum {
    public int minPathSum(int[][] grid) {
        memo = new int[grid.length][grid[0].length];
        return dp(grid, grid.length -1,grid[0].length-1);
    }
    int memo[][];
    private int dp(int[][] grid, int m, int n) {
        if (m == 0 && n == 0){
            return grid[m][n];
        }
        if (m < 0 || n < 0){
            return Integer.MAX_VALUE;
        }
        if (memo[m][n] != 0){
            return memo[m][n];
        }
        memo[m][n] = Math.min(dp(grid, m - 1, n), dp(grid, m, n - 1)) + grid[m][n];
        return memo[m][n];
    }

    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+ grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}
