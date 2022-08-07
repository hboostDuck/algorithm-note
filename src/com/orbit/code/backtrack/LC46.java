package com.orbit.code.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC46 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();

        boolean[] used = new boolean[nums.length];
        backTrack(nums,list,used);
        return res;

    }

    private void backTrack(int[] nums, LinkedList<Integer> list, boolean[] used) {
        if (list.size() == used.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i <nums.length ; i++) {
            if (used[i]){
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            backTrack(nums,list,used);
            list.removeLast();
            used[i] = false;
        }

    }
}
