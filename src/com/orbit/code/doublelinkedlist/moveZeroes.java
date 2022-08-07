package com.orbit.code.doublelinkedlist;

public class moveZeroes {
    public void moveZeroes(int[] nums) {
        int fast=0,slow =0;
        while (fast <nums.length){
            if (nums[fast] !=0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[slow] = 0;
        }
    }
}
