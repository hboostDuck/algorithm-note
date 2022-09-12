package com.orbit.code.hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author: orbit
 * @Date: 2022/09/10/21:48
 * @Description:
 */
public class LC128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (Integer num : set) {
            int cur = num;
            if (!set.contains(cur-1)){
                while (set.contains(cur)){
                    cur++;
                }
            }
            res = Math.max(res,cur-num);
        }
        return res;
    }
    public int longestConsecutive2(int[] nums) {
        // key表示num，value表示num最远到达的连续右边界
        Map<Integer, Integer> map = new HashMap<>();
        // 初始化每个num的右边界为自己
        for (int num : nums) {
            map.put(num, num);
        }

        int ans = 0;
        for (int num : nums) {
            if (!map.containsKey(num - 1)) {
                int right = map.get(num);
                // 遍历得到最远的右边界
                while (map.containsKey(right + 1)) {
                    right = map.get(right + 1);
                }
                // 更新右边界
                map.put(num, right);
                // 更新答案
                ans = Math.max(ans, right - num + 1);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        LC128 l = new LC128();
        l.longestConsecutive2(new int[]{100,1,200,1,3,2,4});
    }
}
