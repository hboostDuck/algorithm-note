package com.orbit.code.sort;

import java.beans.beancontext.BeanContext;
import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] ints = new int[]{8,5,6,5,4,3,4,1,9};
        QuickSort quickSort = new QuickSort();
//        quickSort.quickSort(ints,0,ints.length-1);
        quickSort.qSort(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int lo, int hi) {
        int left = lo,right = hi;
        int mid = nums[left+(right-left)/2];
        while (left < right){
            while (nums[left] < mid){
                left++;
            }
            while (nums[right] > mid){
                right--;
            }
            if (left >= right) break;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
//            if (nums[left] == mid &&nums[right] == mid){
//                right--;
//                left++;
//            }
            if (nums[left] == mid) right--;
            if (nums[right] == mid) left++;
        }
        if (left == right){
            left++;
            right--;
        }
        if (left <hi){
            quickSort(nums,left,hi);
        }
        if (right>lo){
            quickSort(nums,lo,right);
        }
    }


    void qSort(int[] nums,int start,int end){
        if (end <= start){
            return;
        }
        int index = partition(nums,start,end);

        qSort(nums,index+1,end);
        qSort(nums,start,index-1);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int left = start,right = end;
        while (left < right){
            while (left < right && nums[right] >= pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
