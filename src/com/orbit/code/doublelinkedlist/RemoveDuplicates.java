package com.orbit.code.doublelinkedlist;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)return 0;
        int slow =0,fast=0;
        while (fast<nums.length-1){
            if (nums[++fast] !=nums[slow]){
                nums[++slow] = nums[fast];
            }
        }
        return slow;
    }
}
