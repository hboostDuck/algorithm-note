package com.orbit.code.sort;

import java.util.Arrays;

/**
 * @Author: orbit
 * @Date: 2022/09/10/0:27
 * @Description:
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 3, 8, 4, 6, 2};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j]> arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
