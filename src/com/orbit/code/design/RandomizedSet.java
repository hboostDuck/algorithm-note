package com.orbit.code.design;

import java.util.*;

public class RandomizedSet{

    List<Integer> nums;
    Map<Integer,Integer> valToIndex;
    public RandomizedSet() {
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)){
            return false;
        }
        valToIndex.put(val,nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)){
            return false;
        }
        Integer i = valToIndex.get(val);
        valToIndex.put(nums.get(nums.size()-1),i);
        nums.set(i,nums.get(nums.size()-1));
        nums.remove(nums.size()-1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get(new Random().nextInt(nums.size()));
    }

}
