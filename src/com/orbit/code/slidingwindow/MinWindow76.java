package com.orbit.code.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinWindow76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c,need.containsKey(c)?need.get(c)+1:1);
        }

        int left=0,right=0;
        int valid =0;
        int begin = 0,len = Integer.MAX_VALUE;
        int m = 0;
        while (right < s.length()){

            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c,window.containsKey(c)?window.get(c)+1:1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            System.out.println(m++);


            while (valid == need.size()){
                if (right-left <len){
                    begin = left;
                    len = right-left;
                }
                char c1 = s.charAt(left);
                left++;
                if (need.containsKey(c1)){
                    if (window.get(c1).equals(need.get(c1))){
                        valid--;
                    }
                    window.put(c1,window.get(c1)-1);
                }
            }
        }
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = s.charAt(begin++);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        MinWindow76 s = new MinWindow76();
        s.minWindow("ADOBECODEBANC",
                "ABC");
    }
}
