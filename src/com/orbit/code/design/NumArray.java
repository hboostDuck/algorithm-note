package com.orbit.code.design;

public class NumArray {
    public int[] arr;

    public NumArray(int[] nums) {
        arr = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            arr[i+1] = arr[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return arr[right+1] -arr[left];
    }

}
