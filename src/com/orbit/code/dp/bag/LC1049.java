package com.orbit.code.dp.bag;

/**
 * @Author: orbit
 * @Date: 2022/09/06/12:49
 * @Description:
 */
public class LC1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum+= stones[i];
        }
        int target = sum/2;
        int dp[] =  new int[target+1];
        for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] = Math.max(dp[i],dp[i-stone]+stone);
            }
        }
        return sum-2*dp[target];
    }
}
