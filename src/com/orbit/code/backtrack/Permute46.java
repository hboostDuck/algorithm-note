package com.orbit.code.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permute46 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        backTrack(nums);
        return ans;
    }

    private void backTrack(int[] nums) {
        if (track.size() == nums.length){
            ans.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]){
                continue;
            }
            if (i>0 && nums[i] == nums[i-1] && !visited[i - 1]){
                continue;
            }
            track.addLast(nums[i]);
            visited[i] = true;
            backTrack(nums);
            track.removeLast();
            visited[i] = false;
        }
    }
}
