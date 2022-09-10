package com.orbit.code.hot100;



/**
 * @Author: orbit
 * @Date: 2022/09/10/18:53
 * @Description:
 */
public class LC221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] -'0';
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0'){
                    continue;
                }
                dp[i][j] = min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])+1;
            }
        }
        int l = 0;
        for (int[] arr : dp) {
            for (int i : arr) {
                l = Math.max(l,i);
            }
        }
        return l*l;
    }

    private int min(int a, int b, int c) {
        return Math.min(a,Math.min(b,c));
    }
}
