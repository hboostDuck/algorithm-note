package com.orbit.code.sort;

import java.util.Arrays;

/**
 * @Author: orbit
 * @Date: 2022/09/10/0:28
 * @Description:
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8,7,6,5,4,3,2,1,9};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
