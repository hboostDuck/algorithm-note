package com.orbit.code.threeSum;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);

        int l = 0,r= nums.length-1;
        while (l<r){
            if (nums[l]+nums[r] == target){
                return new int[]{l,r};
            }else if(nums[l]+nums[r] < target) {
                l++;
            }else {
                r--;
            }
        }
        return null;
    }

}
