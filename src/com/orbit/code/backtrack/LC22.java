package com.orbit.code.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LC22 {
    public List<String> generateParenthesis(int n) {
        if(n == 0) return null;
        ArrayList<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(n,n,sb,res);
        return res;
    }

    private void backTrack(int left, int right, StringBuilder track, ArrayList<String> res) {
        if (left>right)return;
        if (left<0) return;
        if (left == 0 && right == 0){
            res.add(track.toString());
            track.delete(0,track.length());
            return;
        }

        track.append("(");
        backTrack(left-1, right, track, res);
        track.deleteCharAt(track.length()-1);

        track.append(")");
        backTrack(left, right-1, track, res);
        track.deleteCharAt(track.length()-1);
    }
}
