package com.orbit.review.hot;

import java.util.HashSet;

public class LC128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            integers.add(num);
        }

        int longest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!integers.contains(nums[i] - 1)){
                int tmp = nums[i]+1;
                int length = 1;
                while (integers.contains(tmp)){
                    tmp++;
                    length++;
                }
                longest= Math.max(longest,length);
            }
        }
        return longest;
    }
}
