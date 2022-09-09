package com.orbit.code.dp.bag;

import java.util.Arrays;

/**
 * @Author: orbit
 * @Date: 2022/09/06/22:43
 * @Description:
 */
public class LC322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp =new int[n +1][amount+1];
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            int val = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i-1][j];
                for (int k = 1; k* val <= j; k++) {
                    if (dp[i-1][j-k*val] != Integer.MAX_VALUE){
                        dp[i][j] = Math.min(dp[i][j],dp[i-1][j-k*val]+k);
                    }
                }

            }
        }
        return (dp[n][amount] == Integer.MAX_VALUE)? -1:dp[n][amount];
    }
    public int coinChange2(int[] coins, int amount) {
        int[] dp =new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int coin : coins) {
            for (int j = 0; j <= amount; j++) {
                if (j-coin >=0){
                    dp[j] = Math.min(dp[j],dp[j-coin]+1);
                }

            }
        }
        return (dp[amount] == Integer.MAX_VALUE)? -1:dp[amount];
    }
    public static void main(String[] args) {
        LC322 l = new LC322();
        l.coinChange2(new int[]{2},3);
    }
}

class Solution {
    int INF = Integer.MAX_VALUE;
    public int coinChange(int[] cs, int cnt) {
        int n = cs.length;
        int[][] f = new int[n + 1][cnt + 1];

        // 初始化（没有任何硬币的情况）：只有 f[0][0] = 0；其余情况均为无效值。
        // 这是由「状态定义」决定的，当不考虑任何硬币的时候，只能凑出总和为 0 的方案，所使用的硬币数量为 0
        for (int i = 1; i <= cnt; i++) f[0][i] = INF;

        // 有硬币的情况
        for (int i = 1; i <= n; i++) {
            int val = cs[i - 1];
            for (int j = 0; j <= cnt; j++) {
                // 不考虑当前硬币的情况
                f[i][j] = f[i - 1][j];

                // 考虑当前硬币的情况（可选当前硬币个数基于当前容量大小）
                for (int k = 1; k * val <= j; k++) {
                    if (f[i - 1][j - k * val] != INF) {
                        f[i][j] = Math.min(f[i][j], f[i-1][j-k*val] + k);
                    }
                }
            }
        }
        return f[n][cnt] == INF ? -1 : f[n][cnt];
    }
}
