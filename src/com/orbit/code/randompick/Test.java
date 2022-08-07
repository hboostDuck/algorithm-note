package com.orbit.code.randompick;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test {

}
class Solution {

    int sz;
    Map<Integer,Integer> mapping;

    public Solution(int n, int[] blacklist) {
        mapping = new HashMap<>();
        sz = n - blacklist.length;
        for (int b : blacklist) {
            mapping.put(b,666);
        }
        int last = n-1;
        for (int b : blacklist) {
            if (b>=sz){
                continue;
            }
            while (mapping.containsKey(last)){
                last--;
            }
            mapping.put(b,last);
            last--;
        }
    }

    public int pick() {
        Random random = new Random();
        int i = random.nextInt(sz);
        if (mapping.containsKey(i)){
            return mapping.get(i);
        }
        return i;
    }
}