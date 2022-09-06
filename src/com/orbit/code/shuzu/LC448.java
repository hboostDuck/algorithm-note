package com.orbit.code.shuzu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: orbit
 * @Date: 2022/08/26/20:39
 * @Description:
 */
public class LC448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] vals = new int[n + 1];
        for (int num : nums) {
            vals[num]++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i < vals.length; i++) {
            if (vals[i] == 0){
                res.add(i);
            }
        }
        return res;
    }
}
