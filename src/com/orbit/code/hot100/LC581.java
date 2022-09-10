package com.orbit.code.hot100;

import java.util.Stack;

/**
 * @Author: orbit
 * @Date: 2022/09/10/20:08
 * @Description:
 */
public class LC581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        Stack<Integer> s1 = new Stack<>();
        int left = Integer.MAX_VALUE,right = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            while (!s1.isEmpty() && nums[s1.peek()] > nums[i]){
                left = Math.min(left,s1.pop());
            }
            s1.push(i);
        }
        Stack<Integer> s2 = new Stack<>();
        for (int i = n-1; i >=0; i--) {
            while (!s2.isEmpty() && nums[s2.peek()] < nums[i]){
                right = Math.max(right,s2.pop());
            }
            s2.push(i);
        }
        if (left == Integer.MAX_VALUE && right == Integer.MIN_VALUE){
            return 0;
        }
        return right-left+1;
    }
}
