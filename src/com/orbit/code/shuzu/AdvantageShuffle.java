package com.orbit.code.shuzu;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageShuffle {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
                (int[] pair1,int[] pair2)-> pair2[1]-pair1[1]
        );
        for (int i = 0; i < nums2.length; i++) {
            maxpq.offer(new int[]{i,nums2[i]});
        }
        Arrays.sort(nums1);
        int left =0,right = nums1.length-1;
        int[] res = new int[nums1.length];
        while (!maxpq.isEmpty()){
            int[] poll = maxpq.poll();
            int i = poll[1], max = poll[2];
            if (nums1[right]>max){
                res[i] = nums1[right];
                right--;
            }else {
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
