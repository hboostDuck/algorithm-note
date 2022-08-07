package com.orbit.code.dp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hxy
 * @create 2022-04-07 20:57
 */

public class LengthOfLIS {
    protected static transient Logger logger = LoggerFactory.getLogger(LengthOfLIS.class);
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int m = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    m = Math.max(m,dp[j]);
                }
            }
            dp[i] = m+1;
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(i,max);
        }
        return max;
    }

    public int lengthOfLIS2(int[] nums) {
        int tail[] = new int[nums.length];
        tail[0] = nums[0];
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < tail[j]){
                tail[j] = nums[i];
                j++;
            }
        }
        int ans = 0;
        for (int i : tail) {
            if (i != 0){
                ans++;
            }
        }
        return ans;
    }

    public int lengthOfLIS3(int[] nums) {
       int[] top = new int[nums.length];
       int piles =0;
        for (int i = 0; i < nums.length; i++) {
            int pocker = nums[i];

            int left =0,right =piles;
            while (left< right){
                int mid = (left+right)/2;
                if (top[mid] > pocker){
                    right = mid;
                }else if (top[mid] < pocker){
                    left = mid +1;
                }else {
                    right = mid;
                }
            }
            if (left == piles) piles++;
            top[left] = pocker;
        }

        return piles;
    }

    static boolean flag = false;
    public static void main(String[] args) {



        new Thread(() -> {
            while (!flag){
                logger.info("running...");

            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
    }
}
