package com.orbit.code.maths;

/**
 * @Author: orbit
 * @Date: 2022/09/14/22:44
 * @Description:
 */
public class LC50 {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE){
            return myPow(1 / x, -(n + 1))/x;
        }
        if (n<0){
            return myPow(1/x,-n);
        }
        if (n%2 == 1){
            return x*myPow(x,n-1);
        }else {
            double s = myPow(x,n/2);
            return s*s;
        }
    }
}
