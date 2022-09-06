package com.orbit.code.shuzu;

import java.util.HashMap;

/**
 * @Author: orbit
 * @Date: 2022/09/04/23:38
 * @Description:
 */
public class LC523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1]+ nums[i-1];
        }
        HashMap<Integer, Integer> valToIdx = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int val = preSum[i] % k;
            if (!valToIdx.containsKey(val)){
                valToIdx.put(val,i);
            }
        }
        for (int i = 1; i <= n; i++) {
            int val = preSum[i] % k;
            if (valToIdx.containsKey(val)){
                if (i-valToIdx.get(val) >=2){
                    return true;
                }
            }
        }
        return false;
    }
}
