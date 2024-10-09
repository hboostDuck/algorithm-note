package com.orbit.review2.hot;

public class LC121 {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length+1][2];

        //dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i])
        //dp[i][1] = max(dp[i-1][1], -prices[i])
        for (int i = 0; i < length; i++) {
            if (i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
            }else {
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
            }
        }
        return  dp[length-1][0];
    }
}
