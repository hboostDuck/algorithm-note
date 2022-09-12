package com.orbit.code.hot100;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: orbit
 * @Date: 2022/09/12/16:55
 * @Description:
 */
public class LC85 {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[m];
        for (char[] chars : matrix) {
            for (int j = 0; j < m; j++) {
                if (chars[j] == '1') {
                    arr[j] += 1;
                } else {
                    arr[j] = 0;
                }
            }
            res = Math.max(res, maxRec(arr));
        }
        return res;
    }

    private int maxRec(int[] arr) {
        int res =0;
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = -1;
        right[n-1] = n;
        for (int i = 1; i < n; i++) {
            int index = i-1;
            int tmp = arr[i];
            while (index >=0){
                if (arr[index] < tmp)break;
                index = left[index];
            }
            left[i] = index;
        }
        for (int i = n-2; i >=0; i--) {
            int index = i+1;
            int tmp = arr[i];
            while (index < n){
                if (arr[index] < tmp) break;
                index = right[index];
            }
            right[i] = index;
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res,(right[i]-left[i]-1)*arr[i]);
        }
        return res;
    }
}
