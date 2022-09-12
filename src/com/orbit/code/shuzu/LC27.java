package com.orbit.code.shuzu;

import javax.swing.plaf.SliderUI;
import javax.xml.stream.FactoryConfigurationError;

/**
 * @Author: orbit
 * @Date: 2022/09/13/0:26
 * @Description:
 */
public class LC27 {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0,right = 0;
        while (right < n){
           if (nums[right] != val){
               nums[left] = nums[right];
               left++;
           }
           right++;
        }
        return left;
    }
}
