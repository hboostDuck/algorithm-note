package com.orbit.review2.hot;

public class LC338 {
    public int[] countBits(int n) {


        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i%2 == 1){
                ans[i] = ans[i-1]+1;
            }else{
                ans[i] = ans[i/2];
            }
        }
        return ans;

    }
}
