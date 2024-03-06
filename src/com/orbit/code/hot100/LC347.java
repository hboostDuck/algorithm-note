package com.orbit.code.hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: orbit
 * @Date: 2022/09/11/10:47
 * @Description:
 */
public class LC347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)){
                map.put(num,1);
            }else {
                map.put(num,map.get(num)+1);
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> b[1] -a[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(),c = entry.getValue();
            q.offer(new int[]{num,c});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q.poll()[0];
        }
        return res;
    }

    //快速排序
//    public int[] topKFrequent2(int[] nums, int k) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            if (!map.containsKey(num)){
//                map.put(num,1);
//            }else {
//                map.put(num,map.get(num)+1);
//            }
//        }
//
//    }

}
