package com.orbit.code.dp;


import java.util.Arrays;


public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0]-o2[0] == 0){
                return o2[1] - o1[1];
            }else {
                return o1[0] - o2[0];
            }
        });
        int[] height = new int[n];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }
        return lis(height);
    }

    private int lis(int[] height) {
        int[] dp = new int[height.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                if (height[i] > height[j]){
                    dp[i] = Math.max(dp[i],1+ dp[j]);
                }
            }
        }
        int res =1;
        for (int i : dp) {
            res = Math.max(res,i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] envelopes = new int[][]{{5,4}, {6,4}, {6,7}, {2,3}};


        for (int[] envelope : envelopes) {
            System.out.println(Arrays.toString(envelope));
        }
    }
}
