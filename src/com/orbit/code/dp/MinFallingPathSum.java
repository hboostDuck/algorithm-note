package com.orbit.code.dp;

import java.util.Arrays;

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        memo = new int[n][n];
        for (int[] ints : memo) {
            Arrays.fill(ints,666666);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res , dp(matrix,n-1,i));
        }
        return res;
    }
    int[][] memo;
    private int dp(int[][] matrix, int i, int j) {
        if ( i < 0 || j < 0 || i >=matrix.length || j >= matrix.length){
            return 666666;
        }
        if (i == 0 ){
            return matrix[i][j];
        }
        if (memo[i][j] != 666666){
            return memo[i][j];
        }
        memo[i][j]= matrix[i][j] + min(dp(matrix, i - 1, j), dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j + 1));
        return memo[i][j];
    }

    private int min(int dp, int dp1, int dp2) {
        return Math.min(dp,Math.min(dp1,dp2));
    }
}
