package com.orbit.code.dp;

import java.util.Arrays;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(),n = word2.length();
        memo = new int[m][n];
        for (int[] ints : memo) {
            Arrays.fill(ints, 666666);
        }
        return dp(word1,m-1,word2,n-1);
    }

    int[][] memo;
    private int dp(String s1, int i, String s2, int j) {
        if (i == -1) return j+1;
        if (j == -1) return i+1;
        if (s1.charAt(i) == s2.charAt(j)){
            return dp(s1,i-1,s2,j-1);
        }
        if (memo[i][j] != 666666){
            return memo[i][j];
        }
        memo[i][j] = min(dp(s1, i, s2, j - 1) + 1,
                dp(s1, i - 1, s2, j) + 1,
                dp(s1, i - 1, s2, j - 1) + 1);
        return memo[i][j];

    }

    private int min(int i, int j, int k) {
        return Math.min(i,Math.min(j,k));
    }
}
