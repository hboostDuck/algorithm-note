package com.orbit.review.dp;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo,-666);
        return dp(coins,amount);
    }
    int memo[];
    private int dp(int[] coins, int amount) {
        if (amount < 0){
            return -1;
        }
        if (amount == 0){
            return 0;
        }
        if (memo[amount] != -666){
            return memo[amount];
        }
        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {

            int sub = dp(coins, amount - coin);

            if (sub == -1) continue;
            minCount = Math.min(minCount, 1 +sub);
        }
        memo[amount] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        return memo[amount] ;
    }

    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 0; i <dp.length; i++) {
            for (int coin : coins) {
                if (i-coin <0) {
                    continue;
                }
                dp[i] = Math.min(dp[i],1+dp[i-coin]);
            }
        }
        
        return dp[amount] == amount+1?-1:dp[amount];
    }
}
