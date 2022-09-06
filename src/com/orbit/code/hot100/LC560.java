package com.orbit.code.hot100;

import com.sun.javafx.robot.FXRobotImage;
import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import java.util.HashMap;

/**
 * @Author: orbit
 * @Date: 2022/09/04/23:09
 * @Description:
 */
public class LC560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
            int need = preSum[i] - k;
            if (map.containsKey(need)){
                res += map.get(need);
            }
            // 将当前前缀和存入哈希表
            if (!map.containsKey(preSum[i])) {
                map.put(preSum[i], 1);
            } else {
                map.put(preSum[i], map.get(preSum[i]) + 1);
            }
        }
        return res;
    }
}
