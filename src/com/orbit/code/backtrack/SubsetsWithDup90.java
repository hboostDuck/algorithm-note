package com.orbit.code.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDup90 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        backTrack(nums,0);
        return ans;
    }
    private void backTrack(int[] nums,int start) {
        ans.add(new ArrayList<>(track));
        for (int j = start; j < nums.length; j++) {
            if (j>start && nums[j] == nums[j-1]){
                continue;
            }
            track.addLast(nums[j]);
            backTrack(nums,j+1);
            track.removeLast();
        }
    }
}
