package com.orbit.code.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine77 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTrack(1,n,k);
        return ans;
    }

    private void backTrack(int start, int n, int k) {
        if (k == track.size()){
            ans.add(new LinkedList<>(track));
        }

        for (int i = start; i < n; i++) {
            track.addLast(i);
            backTrack(i+1,n,k);
            track.removeLast();
        }

    }

}
