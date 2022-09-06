package com.orbit.code.hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: orbit
 * @Date: 2022/09/04/22:25
 * @Description:
 */
public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String code = encode(str);
            map.putIfAbsent(code,new LinkedList<>());
            map.get(code).add(str);
        }
        return new LinkedList<>(map.values());
    }

    private String encode(String str) {
        char[] code = new char[26];
        for (char c : str.toCharArray()) {
            int a = c - 'a';
            code[a]++;
        }
        return new String(code);
    }
}
