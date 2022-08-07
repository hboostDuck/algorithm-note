package com.orbit.code.doublelinkedlist;

public class ReverseString344 {
    public void reverseString(char[] s) {
        int l = 0,r = s.length-1;
        char tmp;
        while (l<r){
            tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
         }
    }
}
