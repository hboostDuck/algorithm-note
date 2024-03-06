package com.orbit.code.water;

import javax.lang.model.util.ElementScanner6;
import java.util.concurrent.CompletableFuture;

/**
 * @Author: orbit
 * @Date: 2022/08/26/19:08
 * @Description:
 */
public class LC11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int res = 0;
        while (left < right){
            int maxArea = Math.min(height[left],height[right])* (right-left);

            res = Math.max(res,maxArea);
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }

//    public static void main(String[] args) {
//        CompletableFuture<Object> future = CompletableFuture.completedFuture(Integer);
//        future.
//    }
}
