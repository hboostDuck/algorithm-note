package com.orbit.code.hot100;

/**
 * @Author: orbit
 * @Date: 2022/09/10/18:28
 * @Description:
 */
public class LC33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int mid = left + (right-left)/2;
        while (left <= right){
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] >= nums[left]){
                if (nums[mid] > target && target >= nums[left] ){
                    right = mid -1;
                }else {
                    left = mid +1;
                }
            }else {
                if (target > nums[mid] && target <= nums[right]){
                    left = mid +1;
                }else {
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}
