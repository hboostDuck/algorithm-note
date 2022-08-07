package com.orbit.code.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hxy
 * @create 2022-04-18 20:03
 */
public class Subsets {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums,0);
        return ans;
    }

    private void backTrack(int[] nums,int i) {
        ans.add(new ArrayList<>(track));
        for (int j = i; j < nums.length; j++) {
            track.addLast(nums[j]);
            backTrack(nums,j+1);
            track.removeLast();
        }
    }
}
