package com.orbit.code.hot100;

import java.util.Stack;

/**
 * @Author: orbit
 * @Date: 2022/09/05/22:26
 * @Description:
 */
public class lc394 {
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        Stack<Integer> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '['){
                s1.push(num);
                s2.push(sb.toString());
                num = 0;
                sb = new StringBuilder();
            }else if (chars[i] == ']'){
                StringBuilder tmp = new StringBuilder();
                Integer n = s1.pop();
                for (int j = 0; j < n; j++) {
                    tmp.append(sb);
                }
                sb = new StringBuilder(s2.pop()+tmp);
            }else if (chars[i] >= '1' && chars[i] <= '9'){
                num = num * 10 +  (chars[i] -'0');
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        lc394 l = new lc394();
        l.decodeString("3[a]2[bc]");
    }
}
