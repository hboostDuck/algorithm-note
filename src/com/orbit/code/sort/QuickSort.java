package com.orbit.code.sort;

public class QuickSort {

    private QuickSort() {

    }

    static class InnerClass {
        static final QuickSort QS = new QuickSort();
    }

    public static QuickSort getQS() {
        return InnerClass.QS;
    }

    private static volatile QuickSort ins = null;

    public static QuickSort getInstance() {
        if (ins != null) {
            return ins;
        }
        synchronized (QuickSort.class) {
            if (ins != null) {
                return ins;
            }
            return new QuickSort();
        }
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int lo, int hi) {
        int left = lo;
        int right = hi;
        int mid = nums[left + (right - left) / 2];
        while (left < right) {
            while (nums[left] < mid) {
                left++;
            }
            while (nums[right] > mid) {
                right--;
            }
            if (left >= right) {
                break;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;

            if (nums[left] == mid) right--;
            if (nums[right] == mid) left++;
        }

        if (left == right) {
            left++;
            right--;
        }
        if (lo < right) {
            quickSort(nums, lo, right);
        }
        if (left < hi) {
            quickSort(nums, left, hi);
        }

    }
}
