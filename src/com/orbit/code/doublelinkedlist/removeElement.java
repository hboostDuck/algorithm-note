package com.orbit.code.doublelinkedlist;

public class removeElement {
    public int removeElement(int[] nums, int val) {
        int fast=0,slow=0;
        while (fast<nums.length){
            if (nums[fast] !=val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;

        }
        return slow;
    }
}
