package com.orbit.code.sort.divid;



/**
 * @Author: orbit
 * @Date: 2022/09/10/16:09
 * @Description:
 */
public class LC493 {
    public int reversePairs(int[] nums) {
        mSort(nums);
        return count;
    }

    int[] temp;
    private void mSort(int[] nums) {
        int n = nums.length;
        temp = new int[n];
        mSort(nums,0,n-1);

    }

    private void mSort(int[] nums, int start, int end) {
        if (end <= start) return;
        int mid = start+ (end-start)/2;
        mSort(nums,start,mid);
        mSort(nums,mid+1,end);
        merge(nums,start,mid,end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }

        int hi = mid +1;
        for (int i = start; i <= mid; i++) {
            while (hi <= end && (long)nums[i] > (long)nums[hi]*2 ){
                hi++;
            }
            count += hi-(mid+1);
        }

        int i = start,j = mid+1;
        for (int p = start; p <= end; p++) {
            if (i == mid+1){
                nums[p] = temp[j++];
            } else if (j == end + 1) {
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            }else {
                nums[p] = temp[i++];
            }
        }
    }

    int count = 0;

    public static void main(String[] args) {
        LC493 l = new LC493();
        l.mSort(new int[]{1,3,2,3,1});
    }
}
