package com.orbit.code.threeSum;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> tuples = twoSum(nums,i+1, -nums[i]);
            if (!tuples.isEmpty()){
                for (List<Integer> tuple : tuples) {
                    tuple.add(i);
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
            int sum = nums[l]+nums[r];
            if (sum ==target){
                List<Integer> res = new ArrayList<>();
                res.add(nums[l]);
                res.add(nums[r]);
                ans.add(res);
                l++;
                r--;
            }else if (sum < target){
                l++;
            }else {
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        List<List<Integer>> lists = t.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists.toString());
    }
}


