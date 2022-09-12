package com.orbit.code.offer1;

/**
 * @Author: orbit
 * @Date: 2022/09/11/19:24
 * @Description:
 */
public class LC15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0){
            n &= n-1;
            count++;
        }
        return count;
    }
}
