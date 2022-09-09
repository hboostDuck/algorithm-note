package com.orbit.code.greed;

import com.sun.javafx.robot.FXRobotImage;

/**
 * @Author: orbit
 * @Date: 2022/09/08/23:23
 * @Description:
 */
public class LC45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = n;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <i; j++) {
                if (j+nums[j] >= i){
                    dp[i] = Math.min(dp[i],1+dp[j]);
                }
            }
        }
        return dp[n-1];
    }
    public int jump2(int[] nums) {
        int n = nums.length;
        int end = 0,fast = 0;
        int jumps = 0;
        for (int i = 0; i < n-1; i++) {
            fast = Math.max(fast,nums[i]+i);
            if (end == i){
                jumps++;
                end = fast;
            }
        }
        return jumps;
    }
}
