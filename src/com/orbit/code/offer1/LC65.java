package com.orbit.code.offer1;

/**
 * @Author: orbit
 * @Date: 2022/09/13/0:08
 * @Description:
 */
public class LC65 {
    public int add(int a, int b) {
        if (a == 0 || b == 0){
            return a==0?b:a;
        }

        int sum = a^ b;
        int carry = (a& b) << 1;
        return add(sum,carry);
    }
}
