package com.orbit.code.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class combinationSum240 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return ans;
        }
        // 先排序，让相同的元素靠在一起
        Arrays.sort(candidates);
        backTrack(candidates,0,target);
        return ans;
    }

    private void backTrack(int[] nums,int start,int target) {
        if (trackSum == target){
            ans.add(new ArrayList<>(track));
        }
        if (trackSum > target){
            return;
        }

        for (int j = start; j < nums.length; j++) {
            if (j>start && nums[j] == nums[j-1]){
                continue;
            }
            track.addLast(nums[j]);
            backTrack(nums,j+1,target);
            track.removeLast();
        }
    }
}
