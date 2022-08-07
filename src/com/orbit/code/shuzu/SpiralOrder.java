package com.orbit.code.shuzu;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        int upper_bound= 0,down_bound=m-1;
        int left_bound = 0,right_bound=n-1;
        List<Integer> res = new ArrayList<>();
        while (res.size() <m*n){
            if (upper_bound <= down_bound){
                for (int i = left_bound; i <= right_bound; i++) {
                    res.add(matrix[upper_bound][i]);
                }
                upper_bound++;
            }
            if (right_bound>=left_bound){
                for (int i = upper_bound; i <= down_bound ; i++) {
                    res.add(matrix[i][right_bound]);
                }
                right_bound--;
            }
            if (upper_bound <= down_bound){
                for (int i = right_bound; i >=left_bound; i--) {
                    res.add(matrix[down_bound][i]);
                }
                down_bound--;
            }
            if (right_bound>=left_bound){
                for (int i = down_bound; i >=upper_bound; i--) {
                    res.add(matrix[i][left_bound]);
                }
                left_bound++;
            }
        }
        return res;
    }
}
