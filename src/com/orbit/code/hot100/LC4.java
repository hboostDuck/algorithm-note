package com.orbit.code.hot100;

/**
 * @Author: orbit
 * @Date: 2022/09/12/12:53
 * @Description:
 */
public class LC4 {

    /**
     * trick
     * 我们分别找第 (m+n+1) / 2 个，和 (m+n+2) / 2 个，然后求其平均值即可，这对奇偶数均适用。
     * 加入 m+n 为奇数的话，那么其实 (m+n+1) / 2 和 (m+n+2) / 2 的值相等，
     * 相当于两个相同的数字相加再除以2，还是其本身。
     * @param nums1
     * @param nums2
     * @return
     */
//    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
//        int left = 0,right = 0;
//        int n1 = nums1.length;
//        int n2 = nums2.length;
//        int pivot = (n1+n2-1)/2;
//        int p = 0;
//        while (p!=pivot){
//            if (le)
//            p++;
//        }
//    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length,n = nums2.length;
        int left = (m+n+1)/2,right = (m+n+2)/2;
        return (findKth(nums1,0,nums2,0,left)+findKth(nums1,0,nums2,0,right))/2;
    }

    private double findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i == nums1.length) return nums2[j+k-1];
        if (j == nums2.length) return nums1[i+k-1];
        if (k == 1){
            return Math.min(nums1[i],nums2[j]);
        }
        int minVal1 = (i+k/2-1)<nums1.length? nums1[i+k/2-1]:Integer.MAX_VALUE;
        int minVal2 = (j+k/2-1)<nums2.length? nums2[j+k/2-1]:Integer.MAX_VALUE;
        if (minVal2 >minVal1){
            return findKth(nums1,i+k/2,nums2,j,k/2);
        }else {
            return findKth(nums1,i,nums2,j+k/2,k/2);
        }
    }
}
