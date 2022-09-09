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
        for (int i = 1; i <= stones.length; i++) {
            for (int j = target; j >0; j--) {
                if (j >= stones[i-1]){
                    dp[j] = Math.max(dp[j],dp[j-stones[i-1]]+stones[i-1]);
                }
            }
        }
        return sum- 2*dp[target];
    }
}
