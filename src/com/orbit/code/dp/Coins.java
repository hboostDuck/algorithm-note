package com.orbit.code.dp;

import java.util.Arrays;

/**
 * @author hxy
 * @create 2022-04-07 19:55
 */
public class Coins {
    int[] memo;
    public int coins1(int[] c,int mount){
        return dp1(c,mount);
    }

    private int dp1(int[] c, int mount) {
        if (mount == 0) return 0;
        if (mount < 0) return -1;
        int res =Integer.MAX_VALUE;
        for (int i : c) {
            int sub = dp1(c,mount-i);
            if (sub ==-1) continue;
            res = Math.min(res,sub+1);
        }
        return res == Integer.MAX_VALUE ? -1:res;
    }

    public int coins(int[] c,int mount){
        memo = new int[mount + 1];
        Arrays.fill(memo, -666);
        return dp(c,mount);
    }

    private int dp(int[] c, int mount) {
        if (mount == 0) return 0;
        if (mount < 0) return -1;
        // 查备忘录，防止重复计算
        if (memo[mount] != -666)
            return memo[mount];
        int res =Integer.MAX_VALUE;
        for (int i : c) {
            int sub = dp(c,mount-i);
            if (sub ==-1) continue;
            res = Math.min(res,sub+1);
        }
        // 把计算结果存入备忘录
        memo[mount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return res == Integer.MAX_VALUE ? -1:res;
    }

    int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1，初始值也为 amount + 1
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if(i -coin <0){
                    continue;
                }
                dp[i] = Math.min(dp[i], 1+ dp[i-coin]);
            }
        }
        return dp[amount] == (amount+1) ? -1 :dp[amount];
    }
}
