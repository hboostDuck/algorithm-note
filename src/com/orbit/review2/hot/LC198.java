package com.orbit.review2.hot;

public class LC198 {

    public static void main(String[] args) {
        int[] nums = {2,1,1,2};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+3];
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            if (i == 1){
                dp[i] = nums[i-1];
            }else{
                dp[i] = Math.max(dp[i-2]+ nums[i-1],dp[i-1]);
            }
        }
        int res = 0;
        for (int i = 0; i <= len; i++) {
            res = Math.max(res, dp[i]);
        }
        return  res;
    }
}
