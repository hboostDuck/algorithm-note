package com.orbit.review.dp;

import java.util.Arrays;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <i; j++) {
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }

        }
        int res = 1;
        for (int i : dp) {
            if (i>res){
                res = i;
            }
        }
        return res;
    }

    public int lengthOfLIS1(int[] nums) {
        int[] top = new int[nums.length];
        int piles = 0;

        for (int i = 0; i < nums.length; i++) {
            int poker = nums[i];
            int left = 0,right = piles;
            while (left < right){
                int mid = (left + right)/2;
                if (top[mid] >poker){
                    right = mid;
                }else if (top[mid] < poker){
                    left = mid +1;
                }else {
                    right = mid;
                }
            }
            if (left == piles) piles++;
            top[left] = poker;
        }
        return piles;
    }
}
