package com.orbit.review.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {

    HashMap<Integer,Integer> keyToVal;
    HashMap<Integer,Integer> keyToFreq;
    HashMap<Integer, LinkedHashSet<Integer>> FreqToKeys;
    int cap;
    int minFreq;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        FreqToKeys = new HashMap<>();
        cap = capacity;
        minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)){
            return -1;
        }
        Integer val = keyToVal.get(key);
        increteFreq(key);
        return val;
    }

    private void increteFreq(int key) {
        Integer freq = keyToFreq.get(key);
        keyToFreq.put(key,freq+1);
        FreqToKeys.get(freq).remove(key);
        FreqToKeys.putIfAbsent(freq+1,new LinkedHashSet<>());
        FreqToKeys.get(freq+1).add(key);
        if (FreqToKeys.get(freq).isEmpty()){
            minFreq++;
        }
    }

    public void put(int key, int value) {
        if (keyToVal.containsKey(key)){
            keyToVal.put(key,value);
            increteFreq(key);
        }
        if (keyToVal.size() > cap){
            remove();
        }
        keyToVal.put(key,value);
        keyToFreq.put(key,1);
        FreqToKeys.putIfAbsent(1,new LinkedHashSet<>());
        FreqToKeys.get(1).add(key);
        minFreq = 1;
    }

    private void remove() {
        LinkedHashSet<Integer> keyList = FreqToKeys.get(minFreq);
        Integer key = keyList.iterator().next();
        keyToVal.remove(key);
        keyToFreq.remove(key);
        keyList.remove(key);
        if (keyList.isEmpty()){
            FreqToKeys.remove(this.minFreq);
        }
    }
}
