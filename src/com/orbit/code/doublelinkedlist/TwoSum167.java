package com.orbit.code.doublelinkedlist;

public class TwoSum167 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        while (numbers[l]+numbers[r] != target){
            if (numbers[l]+numbers[r] >target){
                r--;
            }
            if (numbers[l]+numbers[r] <target){
                l++;
            }
        }
        return new int[]{l+1,r+1};
    }
}
