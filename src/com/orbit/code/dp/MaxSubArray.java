package com.orbit.code.dp;

import java.util.Arrays;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        int[] dp = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        int res = Integer.MIN_VALUE;
        for (int i : dp) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
