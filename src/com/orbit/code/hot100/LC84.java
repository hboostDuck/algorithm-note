package com.orbit.code.hot100;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: orbit
 * @Date: 2022/09/11/14:54
 * @Description:
 */
public class LC84 {
    //暴力法
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int curHeight = heights[i];
            for (int j = i; j <heights.length; j++) {
                curHeight = Math.min(curHeight,heights[j]);
                res = Math.max(res,(j-i+1)* curHeight);

            }
        }

        return res;
    }
    //双指针
    public int largestRectangleArea2(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int left = i,right = i;
            while (left>= 0){
                if (heights[left] < height) break;
                left--;
            }
            while (right < heights.length){
                if (heights[right] < height) break;
                right++;
            }
            int width = right-left -1;
            res = Math.max(res,width*height);
        }

        return res;
    }

    public int largestRectangleArea3(int[] heights) {
        int res = 0;
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = heights[i];
            int index = i-1;
            while (index >= 0 ){
                if (heights[index] >= tmp) {
                    index = left[index];
                }else {
                    break;
                }
            }
            left[i] = index;
        }
        for (int i = n-1; i >=0; i--) {
            int tmp = heights[i];
            int index = i+1;
            while (index < n){
                if (heights[index] < tmp){
                    break;
                }
                index = right[index];
            }
            right[i] = index;
        }

        for (int i = 0; i < n; i++) {
            res = Math.max(res,(right[i]-left[i]-1)*heights[i]);
        }
        return res;
    }
    public int largestRectangleArea4(int[] heights) {
        int res = 0;

        Stack<Integer> s = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            left[i] = s.isEmpty()? -1:s.peek();
            s.push(i);
        }
        s.clear();
        for (int i = n-1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            right[i] = s.isEmpty()? n:s.peek();
            s.push(i);
        }
        // 遍历所有柱子，计算面积
        for (int i = 0; i < n; i++){
            int currArea = (right[i] - left[i] - 1) * heights[i];
            res = Math.max(currArea,res);
        }

        return res;
    }
    public int largestRectangleArea5(int[] heights) {
        int res = 0;

        Stack<Integer> s = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right,n);
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]){
                right[s.pop()] = i;
            }
            left[i] = s.isEmpty()? -1:s.peek();
            s.push(i);
        }
//        while (!s.isEmpty()){
//
//        }
        // 遍历所有柱子，计算面积
        for (int i = 0; i < n; i++){
            int currArea = (right[i] - left[i] - 1) * heights[i];
            res = Math.max(currArea,res);
        }

        return res;
    }
}
