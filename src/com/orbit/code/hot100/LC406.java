package com.orbit.code.hot100;

import java.util.*;

/**
 * @Author: orbit
 * @Date: 2022/09/05/22:23
 * @Description:
 */
public class LC406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->{
            if(a[0] == b[0]){
                return a[1]- b[1];
            }
            return b[0] - a[0];
        });
        List<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[0][0]);
    }
}
