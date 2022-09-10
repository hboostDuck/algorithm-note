package com.orbit.code.hot100;

import java.util.Arrays;

/**
 * @Author: orbit
 * @Date: 2022/09/10/21:06
 * @Description:
 */
public class LC31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int k = 0;
        for (int i = n-1; i >= 0; i--) {
            if (i == 0){
                Arrays.sort(nums);
                return;
            }
            if (nums[i] > nums[i-1]) {
                k = i;
                break;
            }
        }
        Arrays.sort(nums,k,n-1);
        for (int i = k; i < n; i++) {
            if (nums[i] > nums[k-1]){
                int tmp = nums[i];
                nums[i] = nums[k-1];
                nums[k-1] = tmp;
                break;
            }
        }
        Arrays.sort(nums,k,n-1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        int[] arr1 = {5,4,3,2,1};
        Arrays.sort(arr1,2,5);
        LC31 l = new LC31();
//        l.nextPermutation(arr);
        System.out.println(Arrays.toString(arr1));
    }
}
