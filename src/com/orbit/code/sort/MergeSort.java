package com.orbit.code.sort;

import java.util.Arrays;

/**
 * @Author: orbit
 * @Date: 2022/09/10/0:27
 * @Description:
 */
public class MergeSort {

    private int[] temp;

    void sort(int[] nums){
        int n = nums.length;
        temp = new int[n];
        mSort(nums,0,n-1);
    }
    void mSort(int[] nums,int start,int end){
        if (end <= start){
            return;
        }
        int mid = start+(end-start)/2;
        mSort(nums,start,mid);
        mSort(nums,mid+1,end);

        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }
        // 双指针合并两个有序数组
        int i = start,j = mid+1;
        for (int k = start; k <= end; k++) {
            if (i == mid + 1) {
                // 左半边数组已全部被合并
                nums[k] = temp[j++];
            } else if (j == end + 1) {
                // 右半边数组已全部被合并
                nums[k] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[k] = temp[j++];
            } else {
                nums[k] = temp[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,7,6,5,4,3,2,1,9};
        MergeSort m = new MergeSort();
        m.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
