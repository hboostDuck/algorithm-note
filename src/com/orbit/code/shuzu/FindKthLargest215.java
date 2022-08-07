package com.orbit.code.shuzu;

import java.util.PriorityQueue;

/**
 * @author hxy
 * @create 2022-04-12 21:31
 */
public class FindKthLargest215 {
    public static int findKthLargest(int[] nums, int k) {
        final PriorityQueue<Integer> integers = new PriorityQueue<>((o1, o2) -> {
            return o2-o1;
        });
        for (int num : nums) {
            integers.offer(num);
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = integers.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        final int[] ints = {90, 10, 3, 4, 5, 6, 7, 8};
        final int kthLargest = findKthLargest(ints, 3);
        System.out.println(kthLargest);
    }
}
