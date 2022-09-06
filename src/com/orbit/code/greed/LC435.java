package com.orbit.code.greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: orbit
 * @Date: 2022/08/20/20:26
 * @Description:
 */
public class LC435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervalSchedule(intervals);
        return intervals.length-n;
    }

    private int intervalSchedule(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int count =1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end){
                count++;
                end = intervals[i][1];
            }
        }
        return count;
    }
}
