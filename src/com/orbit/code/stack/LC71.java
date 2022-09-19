package com.orbit.code.stack;

import java.util.Stack;

/**
 * @Author: orbit
 * @Date: 2022/09/13/18:55
 * @Description:
 */
public class LC71 {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> s = new Stack<>();
        for (String str : strs) {
            if(str.isEmpty() || str.equals(".")){
                continue;
            }
            if (str.equals("..")){
                if (!s.isEmpty())s.pop();
                continue;
            }
            s.push(str);
        }
        String res ="";
        while (!s.isEmpty()){
            res = "/"+s.pop()+res;
        }
        return res.isEmpty()? "/":res;
    }
}
