package com.orbit.code.sort;


import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8,7,6,5,4,3,2,1,9};
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i;
            while (j>0 && temp< arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
