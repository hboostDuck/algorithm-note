package com.orbit.code.hot100;

/**
 * @Author: orbit
 * @Date: 2022/09/04/18:43
 * @Description:
 */
public class LC287 {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast =0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (nums[fast]!= nums[slow]);
        slow = 0;
        while (nums[slow] != nums[fast]){
            slow  = nums[slow];
            fast = nums[fast];
        }
        return nums[fast];
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
        LC287 l = new LC287();
        l.findDuplicate(nums);
    }
}
