package com.orbit.code.hot100;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author: orbit
 * @Date: 2022/08/30/22:16
 * @Description:
 */
public class LC494 {
    int res =0;
    public int findTargetSumWays(int[] nums, int target) {
        backTrack(nums,0,0,target);
        return res;
    }

    private void backTrack(int[] nums,int i, int sum,int target) {
        if (i == nums.length && sum == target ){
            res++;
            return;
        }

        sum+=nums[i];
        i++;
        backTrack(nums,i,sum,target);
        i--;
        sum-=nums[i];

        sum-=nums[i];
        i++;
        backTrack(nums,i,sum,target);
        i--;
        sum+=nums[i];
    }
    HashMap<String, Integer> memo = new HashMap<>();
    public int findTargetSumWays1(int[] nums, int target) {
        return dp(nums,0,target);
    }

    private int dp(int[] nums, int i, int remain) {
        if (i == nums.length){
            if (remain == 0){
                return 1;
            }
            return 0;
        }
        String key = i+ ","+ remain;
        if (memo.containsKey(key)){
            return memo.get(key);
        }
        int res = dp(nums,i+1,remain+nums[i])+ dp(nums, i + 1, remain + nums[i]);
        // 记入备忘录
        memo.put(key, res);
        return res;
    }

}
