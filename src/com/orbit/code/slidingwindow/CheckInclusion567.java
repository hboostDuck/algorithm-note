package com.orbit.code.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusion567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c,need.containsKey(c)?need.get(c)+1:1);
        }
        int left =0,right=0;
        int valid = 0;
        while (right<s2.length()){

            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c,window.containsKey(c)?window.get(c)+1:1);
                if (need.get(c).equals(window.get(c))){
                    valid++;
                }
            }
            while (right-left >= s1.length()){
                if (valid == need.size()){
                    return true;
                }
                char c1 = s2.charAt(left);
                left++;

                if (need.containsKey(c1)){
                    if (window.get(c1).equals(need.get(c1))){
                        valid--;
                    }
                    window.put(c1,window.get(c1)-1);
                }
            }

        }
        return false;


    }


}
