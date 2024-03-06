package com.orbit.code.offer1;

/**
 * @Author: orbit
 * @Date: 2022/09/21/14:50
 * @Description:
 */
public class LC16 {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE){
            return myPow(1/x ,-(n+1))/x;
        }
        if (n < 0){
            return myPow(1/x,-n);
        }
        if (n %2 == 1){
            return myPow(x,n-1)*x;
        }else {
            double sub = myPow(x,n/2);
            return sub*sub;
        }
    }
}
