package com.orbit.code.hot100;

import com.sun.javafx.robot.FXRobotImage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: orbit
 * @Date: 2022/08/30/21:04
 * @Description:
 */
public class LC139 {

    Set<String> set;
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return dp(0,s);
    }

    private boolean dp(int i, String s) {
        // 防止冗余计算
        if (memo[i] != -1) {
            return memo[i] != 0;
        }
        if (i == s.length()){
            return true;
        }
        for (int len = 1; len < s.length(); len++) {
            String substr = s.substring(i, i+len);
            if (set.contains(substr)){
                boolean subProblem = dp(i + len, s);
                if (subProblem){
                    memo[i] = 1;
                    return true;
                }
            }
        }
        memo[i] = 0;
        return false;
    }

}
