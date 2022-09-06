package com.orbit.code.maths;

public class lc172 {
    public int trailingZeroes(int n) {
        int res =0;
        long divisor = 5;
        while (divisor<=n){
            res += n/divisor;
            divisor*=5;
        }
        return res;
    }
}
