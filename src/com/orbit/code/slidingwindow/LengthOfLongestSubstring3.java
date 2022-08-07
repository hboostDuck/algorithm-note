package com.orbit.code.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> window = new HashMap<>();
        int left =0,right=0;
        int ans = 0;
        int max = 0;
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c,window.containsKey(c)?window.get(c)+1:1);
            if (window.get(c) == 1) max++;
            while (window.get(c) > 1){
                ans = Math.max(ans,max);
                char c1 = s.charAt(left);
                left++;
                if (window.get(c1)>1){
                    window.put(c1,1);
                    max = --max == 0 ? 1 : max;
                }
            }
        }
        return Math.max(ans,max);
    }
}
