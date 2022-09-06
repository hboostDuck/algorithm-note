package com.orbit.code.hot100;

/**
 * @Author: orbit
 * @Date: 2022/09/03/22:19
 * @Description:
 */
public class LC75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0,j = n-1;
        for (int k = 0; k < j; k++) {
            while (k <= j && nums[k] == 2){
                nums[k] = nums[j];
                nums[j] = 2;
                j--;
            }
            if (nums[k] == 0){
                nums[k] = nums[i];
                nums[i] = 0;
                i++;
            }
        }
    }
}
