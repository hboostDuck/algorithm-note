package com.orbit.code.dp.bag;

/**
 * @Author: orbit
 * @Date: 2022/09/06/13:31
 * @Description:
 */
public class LC416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%2 != 0) return false;
        int w = sum/2;
        int n = nums.length;
        boolean[][] dp = new boolean[n +1][w+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j-nums[i-1] <0){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
    public boolean canPartition1(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+= nums[i];
        }
        if (sum %2 != 0) return false;
        sum/=2;
        Boolean[] dp = new Boolean[sum + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j-nums[i-1]];
            }
        }
        return dp[sum];
    }
}
