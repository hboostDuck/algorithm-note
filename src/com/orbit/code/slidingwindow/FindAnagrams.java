package com.orbit.code.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c,need.containsKey(c)?need.get(c)+1:1);
        }
        int left =0,right=0;
        int valid = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (right<=s.length()){

            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c,window.containsKey(c)?window.get(c)+1:1);
                if (need.get(c).equals(window.get(c))){
                    valid++;
                }
            }
            while (right-left == p.length()){
                if (valid == need.size()){
                    list.add(left);
                }
                //left移动
                char c1 = s.charAt(left);
                left++;

                if (need.containsKey(c1)){
                    if (need.get(c1).equals(window.get(c1))){
                        valid--;
                    }
                    window.put(c1,window.get(c1)-1);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FindAnagrams f = new FindAnagrams();
        f.findAnagrams("cbaebabacd"
                ,"abc");
    }
}
