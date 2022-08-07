package com.orbit.code.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {

    HashMap<Integer,Integer> keyToVal;

    HashMap<Integer,Integer> keyToFreq;

    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    int minFreq;

    int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        minFreq =0;
        cap = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)){
            return -1;
        }
        //增加key的freq
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (this.cap <= 0) return;
        //key已存在 修改对应的val
        if (keyToVal.containsKey(key)){
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }
        if (cap<=keyToVal.size()){
            removeMinFreqKey();
        }
        keyToVal.put(key,value);
        keyToFreq.put(key,1);
        freqToKeys.putIfAbsent(1,new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }
    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(minFreq);
        Integer deleteKey = keyList.iterator().next();
        keyList.remove(deleteKey);
        if (keyList.isEmpty()){
            freqToKeys.remove(this.minFreq);
        }
        keyToVal.remove(deleteKey);
        keyToFreq.remove(deleteKey);

    }
    private void increaseFreq(int key) {
        Integer freq = keyToFreq.get(key);
        keyToFreq.put(key,freq+1);
        freqToKeys.get(freq).remove(key);
        freqToKeys.putIfAbsent(freq+1,new LinkedHashSet<>());
        freqToKeys.get(freq+1).add(key);
        if (freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            if (freq == minFreq){
                minFreq ++;
            }
        }
    }


}
