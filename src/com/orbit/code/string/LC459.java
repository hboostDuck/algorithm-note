package com.orbit.code.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: orbit
 * @Date: 2022/09/14/23:00
 * @Description:
 */
public class LC459 {
    public boolean repeatedSubstringPattern(String s) {
        return (s+s).substring(1,s.length()-1).contains(s);
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> tuples = twoSum(nums,i+1, -nums[i]);
            if (!tuples.isEmpty()){
                for (List<Integer> tuple : tuples) {
                    tuple.add(nums[i]);
                    ans.add(tuple);
                }
            }
            while (i<n-1 && nums[i+1] ==nums[i]) i++;
        }
        return ans;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int n = nums.length;
        int l = start,r= n-1;
        List<List<Integer>> ans = new ArrayList<>();
        while (l<r){
            int left = nums[l];
            int right = nums[r];
            int sum = nums[l]+nums[r];
            if (sum ==target){
                List<Integer> res = new ArrayList<>();
                res.add(nums[l]);
                res.add(nums[r]);
                ans.add(res);
                while(l<r && nums[l] == left) l++;
                while(l<r && nums[r] == right) r--;
            }else if (sum < target){
                l++;
            }else {
                r--;
            }
        }
        return ans;
    }
}