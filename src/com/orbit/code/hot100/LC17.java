package com.orbit.code.hot100;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: orbit
 * @Date: 2022/09/04/20:52
 * @Description:
 */
public class LC17 {
    String[] s = new String[]{
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    List<String> res = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        StringBuilder sb = new StringBuilder();
        backtrack(digits,0,sb);
        return res;
    }

    private void backtrack(String digits,int i,StringBuilder path) {
        if (i == digits.length()){
            res.add(path.toString());
            return;
        }
        char[] chars = s[digits.charAt(i) - '0'].toCharArray();
        for (char aChar : chars) {
            backtrack(digits, i + 1, path.append(aChar));
            path.deleteCharAt(path.length() - 1);
        }
    }
}
