package com.orbit.code.hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @Author: orbit
 * @Date: 2022/09/11/19:45
 * @Description:
 */
public class LC621 {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task,map.getOrDefault(task,0)+1);
        }
        int maxNums = 0;
        int maxCount = 0;
        for (Integer value : map.values()) {
            maxCount = Math.max(maxCount,value);
        }
        for (Integer value : map.values()) {
            if (value == maxCount) maxNums++;
        }
        return Math.max(tasks.length,(maxCount-1)*(n+1)+maxNums);
    }
    public int leastInterval2(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task,map.getOrDefault(task,0)+1);
        }
        int t = map.size();
        ArrayList<Integer> restCount = new ArrayList<>(map.values());
        ArrayList<Integer> nextTime = new ArrayList<>(Collections.nCopies(t, 1));
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            time++;
            int minNextTime = Integer.MAX_VALUE;
            for (int j = 0; j < t; j++) {
                if (restCount.get(j) != 0){
                    minNextTime = Math.min(minNextTime,nextTime.get(j));
                }
            }
            time = Math.max(time,minNextTime);
            //执行任务的索引
            int index = -1;
            for (int j = 0; j < t; j++) {
                if (restCount.get(j) >0 && nextTime.get(j) <= time){
                    if (index ==-1 || restCount.get(j) > restCount.get(index)){
                        index = j;
                    }
                }
            }
            restCount.set(index,restCount.get(index)-1);
            nextTime.set(index,time+n+1);
        }
        return time;
    }
    public int leastInterval1(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task,map.getOrDefault(task,0)+1);
        }
        int t = map.size();
        int maxCount = 0;
        int maxNum = 0;
        for (Integer value : map.values()) {
            maxCount = Math.max(maxCount,value);
        }
        for (Integer value : map.values()) {
            if (value == maxCount){
                maxNum++;
            }
        }
        return Math.max(tasks.length,(n+1) * (maxCount-1) +maxNum );
    }

}
