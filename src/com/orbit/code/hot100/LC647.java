package com.orbit.code.hot100;

/**
 * @Author: orbit
 * @Date: 2022/09/10/22:46
 * @Description:
 */
public class LC647 {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <=n-i; j++) {
                if (valid(s,i,j)) count++;
            }
        }

        return count;
    }

    private boolean valid(String s, int len, int start) {
        int i = start,j = start+len -1;
        while (i <= j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //马拉车
//    public int countSubstrings2(String s) {
//
//    }
}
