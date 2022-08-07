package com.orbit.code.shuzu;

/**
 * @author hxy
 * @create 2022-04-12 21:36
 */
public class RemoveDuplicates26 {
    public int removeDuplicates(int[] nums) {
        int s = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[s] ){
                nums[++s] = nums[i];
            }
        }
        return s;
    }


}
