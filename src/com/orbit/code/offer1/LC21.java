package com.orbit.code.offer1;

/**
 * @Author: orbit
 * @Date: 2022/09/13/0:20
 * @Description:
 */
public class LC21 {
    public int[] exchange(int[] nums) {
        int left =0,right = 0;
        while (right<nums.length){
            if (nums[right]%2 == 1){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
        return nums;
    }
}
