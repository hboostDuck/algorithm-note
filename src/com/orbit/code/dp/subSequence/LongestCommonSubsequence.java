package com.orbit.code.dp.subSequence;

import java.util.Arrays;

public class LongestCommonSubsequence {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int[] arr : memo) {
            Arrays.fill(arr,-1);
        }
        return dp(text1,0,text2,0);
    }

    private int dp(String s1, int i, String s2, int j) {
        if( i == s1.length() || j == s2.length()) return 0;
        if (memo[i][j] != -1){
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)){
            memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
            return memo[i][j];
        }else {
            memo[i][j] = Math.max(dp(s1, i + 1, s2, j), dp(s1, i, s2, j + 1));
            return memo[i][j];
        }
    }

    public int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
