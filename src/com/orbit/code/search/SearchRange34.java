package com.orbit.code.search;

import java.util.HashMap;
import java.util.Random;

public class SearchRange34 {
    public int[] searchRange1(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid] == target){
                right = mid;
            }else if (nums[mid] < target ){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }

        if (left >=nums.length) return new int[]{-1,-1};
        int end = left;
        for (int i = left; i <nums.length; i++) {
            if (nums[i] == target){
                end = i;
            }
        }
        return new int[]{left,end};
    }
    public int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid] == target){
                left = mid+1;
            }else if (nums[mid] < target ){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }

        if (left == 0 && nums[left] !=target ) return new int[]{-1,-1};
        if (left >=nums.length || nums[left-1] !=target ) return new int[]{-1,-1};
        int begin = right;
        for (int i = right; i >=0; i--) {
            if (nums[i] == target){
                begin = i;
            }
        }
        return new int[]{begin,right};
    }

    public static void main(String[] args) {
        Random random = new Random(16384);
        int nextInt = random.nextInt();
        int i =  nextInt ^ nextInt >>>16 ;

        System.out.println(i & 4);
/*        HashMap<String, String> map = new HashMap<>();

        String*/


    }
}
