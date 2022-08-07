package com.orbit.code.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combinationSum39 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum =0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates,0,target);
        return ans;
    }

    private void backTrack(int[] nums,int start,int target) {
        // base case，找到目标和，记录结果
        if (trackSum == target) {
            ans.add(new LinkedList<>(track));
            return;
        }
        // base case，超过目标和，停止向下遍历
        if (trackSum > target) {
            return;
        }
        for (int j = start; j < nums.length; j++) {
            trackSum+=nums[j];
            track.addLast(nums[j]);
            backTrack(nums,j,target);
            track.removeLast();
            trackSum-=nums[j];
        }
    }



}
