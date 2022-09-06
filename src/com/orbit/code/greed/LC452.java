package com.orbit.code.greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: orbit
 * @Date: 2022/08/20/21:12
 * @Description:
 */
public class LC452 {
    public int findMinArrowShots(int[][] points) {
        return arrowShots(points);
    }

    private int arrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(n -> n[1]));
        int count = 1;
        int end = points[0][1];
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > end){
                end = points[i][1];
                count++;
            }
        }
        return count;
    }
}
