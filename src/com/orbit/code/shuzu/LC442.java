package com.orbit.code.shuzu;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: orbit
 * @Date: 2022/08/26/21:04
 * @Description:
 */
public class LC442 {
    public static List<Integer> findDuplicates(int[] nums) {

//        LinkedList<Integer> res = new LinkedList<>();
//        for (int num : nums) {
//            if (nums[Math.abs(num)-1] <0){
//                res.add(Math.abs(num));
//            }else {
//                nums[Math.abs(num)-1] *= -1;
//            }
//        }
//        return res;
        int n = nums.length;
        int[] arr = new int[n];
        for (int num : nums) {
            arr[num]++;
        }
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 2){
                res.add(i);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(arr));
    }
}
