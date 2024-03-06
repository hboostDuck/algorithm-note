package com.orbit.review.hot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) -'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i]!=0){
                    sb.append((char) i+'a');
                    sb.append(count[i]);
                }
            }
            String string = sb.toString();
            List<String> stringList = map.getOrDefault(string, new ArrayList<>());
            stringList.add(str);
            map.put(string,stringList);
        }
        return new ArrayList<>(map.values());
    }
}
