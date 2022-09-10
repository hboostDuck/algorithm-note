package com.orbit.code.hot100;

import java.util.Stack;

/**
 * @Author: orbit
 * @Date: 2022/09/10/18:20
 * @Description:
 */
public class LC32 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stk = new Stack<>();
        //以s[i-1]结尾的最长合法括号子串长度
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '('){
                stk.push(i);
                dp[i+1] = 0;
            }else {
                if (!stk.isEmpty()){
                    Integer lIndex = stk.pop();
                    int len = i+1 -lIndex+ dp[lIndex];
                    dp[i+1] = len;
                }else {
                    dp[i+1] = 0;
                }
            }
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(i,res);
        }
        return res;
    }
}
