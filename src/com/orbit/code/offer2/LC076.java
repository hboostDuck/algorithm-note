package com.orbit.code.offer2;

import com.sun.corba.se.impl.presentation.rmi.ExceptionHandlerImpl;
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.Random;

/**
 * @Author: orbit
 * @Date: 2022/09/10/0:12
 * @Description:
 */
public class LC076 {
    public int findKthLargest(int[] nums, int k) {
        return qSort(nums,0,nums.length-1,nums.length-k);
    }

    private int qSort(int[] nums, int start, int end, int index) {
        int position = partition(nums,start,end);
        if (position == index){
            return nums[position];
        }else {
            return position >index ? qSort(nums,start,position-1,index):qSort(nums,position+1,end,index);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int left = start, right = end;
        int pivot = nums[start];
        while (left < right){
            while (left<right && nums[right] >= pivot){
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public int findKthLargest1(int[] nums, int k) {
        int n = nums.length;
        int heapSize = n;
        // 构建大顶堆
        buildMaxHeap(nums,heapSize);

        // 执行k-1次删除堆顶元素
        for (int i = n-1; i > n-k; i--) {
            //将堆顶元素交换到当前堆得末尾
            swap(nums,0,i);
            heapSize--;
            maxHeapify(nums,0,heapSize);
        }
        return nums[0];
    }

    private void maxHeapify(int[] nums, int top, int heapSize) {
        //定义左右子节点
        int left = 2*top +1;
        int right = 2*top +2;

        int largest = top;
        if (right< heapSize && nums[right] > nums[largest])
            largest = right;
        if (left < heapSize && nums[left] > nums[largest]){
            largest = left;
        }

        if (top != largest){
            swap(nums,top,largest);
            maxHeapify(nums,largest,heapSize);
        }
    }

    private void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize/2-1; i >=0; i--) {
            maxHeapify(nums,i,heapSize);
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
