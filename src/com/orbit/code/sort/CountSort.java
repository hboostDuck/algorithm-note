package com.orbit.code.sort;

import java.util.Arrays;

import static com.orbit.code.sort.SelectionSort.swap;

public class CountSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,2,2,2,3,2,1,4};
        int[] temp = new int[5];

        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;
        }
        int j = 0;
        for (int i = 0; i < 5; i++) {
            while (temp[i] >0){
                arr[j] = i;
                j++;
                temp[i]--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
