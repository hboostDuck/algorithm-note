package com.orbit.code.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: orbit
 * @Date: 2022/09/14/13:07
 * @Description:
 */
public class LC93 {
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        res = new LinkedList<>();
        if (n <4 || n >12){
            return res;
        }
        LinkedList<String> path = new LinkedList<>();
        backtrack(s,n,0,4,path);
        return res;
    }

    private void backtrack(String s, int n, int begin, int residue, LinkedList<String> path) {
        if (begin == n ){
            if (residue == 0){
                res.add(String.join(".",path));
            }
            return;
        }
        for (int i = begin; i <begin+3; i++) {
            if (i >=n){
                break;
            }

        }
    }

}
