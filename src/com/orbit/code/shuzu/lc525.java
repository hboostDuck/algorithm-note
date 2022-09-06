package com.orbit.code.shuzu;

import java.util.HashMap;

/**
 * @Author: orbit
 * @Date: 2022/09/04/23:41
 * @Description:
 */
public class lc525 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] PreSum = new int[n];
        for (int i = 1; i <=n; i++) {
            PreSum[i] = PreSum[i-1]+ (nums[i-1] == 0?-1:1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <=n; i++) {
            int val = PreSum[i];
            if (!map.containsKey(val)){
                map.put(val,i);
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int val = PreSum[i];
            Integer integer = map.get(val);
            res = Math.max(res, i-integer);
        }
        return res;
    }
}
