package com.orbit.code.maths;

import java.util.Arrays;

/**
 * @Author: orbit
 * @Date: 2022/09/14/22:58
 * @Description:
 */
public class LC628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0]*nums[1]*nums[n-1],nums[n-1]*nums[n-2]*nums[n-3]);
    }
}
