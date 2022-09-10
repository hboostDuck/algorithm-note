package com.orbit.code.util;

/**
 * @Author: orbit
 * @Date: 2022/09/10/13:16
 * @Description:
 */
public class Utils {
    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
