package com.orbit.code.hot100;

/**
 * @Author: orbit
 * @Date: 2022/09/10/20:39
 * @Description:
 */
public class LC152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, imax = 1,imin = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(nums[i],imax*nums[i]);
            imin = Math.min(nums[i],imin*nums[i]);
            max = Math.max(max,imax);
        }
        return max;
    }
}
