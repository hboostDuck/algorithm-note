package com.orbit.code.greed;

/**
 * @Author: orbit
 * @Date: 2022/09/08/23:14
 * @Description:
 */
public class LC55 {
    public boolean canJump(int[] nums) {
        int fast = 0;
        for (int i = 0; i < nums.length; i++) {
            fast = Math.max(fast,i+nums[i]);
            if (fast <i){
                return false;
            }
        }
        return true;
    }
}
