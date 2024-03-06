package com.orbit.code.offer2;

import java.util.PriorityQueue;

/**
 * @Author: orbit
 * @Date: 2022/09/13/0:53
 * @Description:
 */
class KthLargest {

    PriorityQueue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size()>k){
                pq.poll();
            }
        }
        this.k = k;
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size()>k) pq.poll();
        return pq.peek();
    }
}
