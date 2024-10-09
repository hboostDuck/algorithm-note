package com.orbit.review2.hot.array;

public class LC674 {
    public int findLengthOfLCIS(int[] nums) {

        int len = nums.length;
        if(len == 0) return 0;
        int left =0,right=0;
        int max = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] <= nums[i-1]){
                max = Math.max(max,right-left+1);
                left = i;
                right = i;
            }else {
                right = i;
            }
        }
        if (left == 0){
            max = Math.max(max,len-left);
        }
        return max;
    }

}
