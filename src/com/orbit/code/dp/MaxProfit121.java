package com.orbit.code.dp;

public class MaxProfit121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0,dp_i_1 =Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1 = Math.max(-prices[i],dp_i_1);
        }
        return dp_i_0;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i-1 ==-1){
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }

    public int maxProfit309(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i-1 ==-1){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            if (i-2 == -1){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);

        }
        return dp[n-1][0];
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i-1 ==-1){
                dp[i][0] = 0;
                dp[i][1] = -prices[0]-fee;
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]-fee);
        }
        return dp[n-1][0];
    }

    public int maxProfit123(int[] prices) {
        int max_k =2; int n = prices.length;
        int[][][] dp = new int[n][max_k+1][2];

        for (int i = 0; i < n; i++) {
            for (int k = 1; k <=2; k++) {
                if (i-1 == -1){
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }

    int maxProfit_all_in_one(int max_k, int[] prices, int cooldown, int fee) {
        int n = prices.length;
        int[][][] dp = new int[n][max_k+1][2];

        for (int i = 0; i < n; i++) {
            for (int k = 1; k <=2; k++) {
                if (i-1 == -1){
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i]-fee;
                    continue;
                }
                // 包含 cooldown 的 base case
                if (i - cooldown - 1 < 0) {
                    // base case 2
                    dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                    // 别忘了减 fee
                    dp[i][k][1] = Math.max(dp[i-1][k][1], -prices[i] - fee);
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]-fee);
            }
        }
        return dp[n - 1][max_k][0];
    }

    public static void main(String[] args) {
        MaxProfit121 m = new MaxProfit121();
        m.maxProfit123(new int[]{3,3,5,0,0,3,1,4});
    }
}
