package com.orbit.code.greed;


import java.util.Arrays;

/**
 * @Author: orbit
 * @Date: 2022/08/20/21:50
 * @Description:
 */
public class LC1024 {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> {
            if (a[0] != b[0]){
                return a[0] - b[0];
            }
            return b[1] -a[1];
        });
        int res =0;

        int curEnd = 0,nextEnd = 0;
        int i = 0, n = clips.length;
        while (i<n && clips[i][0] <=curEnd){
            while (i< n && clips[i][0] <= curEnd){
                nextEnd = Math.max(nextEnd,clips[i][1]);
                i++;
            }
            res++;
            curEnd = nextEnd;
            if (curEnd >= time){
                return res;
            }
        }
        return -1;
    }
}
