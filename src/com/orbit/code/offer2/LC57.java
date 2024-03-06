package com.orbit.code.offer2;

/**
 * @Author: orbit
 * @Date: 2022/09/20/17:24
 * @Description:
 */
public class LC57 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int left = 0,right = n-1;
        while (left < right){
            if (nums[left] + nums[right] < target){
                left++;
            }else if (nums[left] + nums[right] > target){
                right--;
            }else {
                return new int[]{nums[left],nums[right]};
            }
        }
        return new int[0];
    }
}
