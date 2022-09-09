package com.orbit.code.sort;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] ints = new int[]{8,7,6,5,4,3,2,1,9};
        int n = ints.length;
        for (int i = 1; i < n; i++) {
            int temp = ints[i];
            int j = i-1;
            while (j>=0 && ints[j] >temp){
                ints[j+1] = ints[j];
                j--;
            }
            ints[j+1] = temp;
        }
        System.out.println(Arrays.toString(ints));
    }
}
