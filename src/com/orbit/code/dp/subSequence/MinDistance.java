package com.orbit.code.dp.subSequence;

import java.util.Arrays;

public class MinDistance {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new int[m][n];
        for (int[] arr : memo) {
            Arrays.fill(arr,666666);
        }
        return dp(word1,m-1,word2,n-1);
    }

    private int dp(String s1, int i, String s2, int j) {
        if (i <= 0) return j+1;
        if (j <= 0) return i+1;
        if (memo[i][j] != 666666){
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)){
            memo[i][j]= dp(s1, i - 1, s2, j - 1);
            return memo[i][j];
        }else {
            memo[i][j] = min(dp(s1, i, s2, j - 1)+1,
                    dp(s1, i - 1, s2, j - 1)+1,
                    dp(s1, i - 1, s2, j)+1);
            return memo[i][j];
        }
    }

    private int min(int dp, int dp1, int dp2) {
        return Math.min(dp,Math.min(dp1,dp2));
    }

}
