package com.orbit.code.shuzu;

public class GenerateMatrix59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int upper_bound= 0,down_bound=n-1;
        int left_bound = 0,right_bound=n-1;
        int num = 1;
        while (num <=n*n+1){
            if (upper_bound <= down_bound){
                for (int i = left_bound; i <= right_bound; i++) {
                    matrix[upper_bound][i] = num++;
                }
                upper_bound++;
            }
            if (right_bound>=left_bound){
                for (int i = upper_bound; i <= down_bound ; i++) {
                    matrix[i][right_bound] = num++;
                }
                right_bound--;
            }
            if (upper_bound <= down_bound){
                for (int i = right_bound; i >=left_bound; i--) {
                    matrix[down_bound][i] = num++;
                }
                down_bound--;
            }
            if (right_bound>=left_bound){
                for (int i = down_bound; i >=upper_bound; i--) {
                    matrix[i][left_bound] = num++;
                }
                left_bound++;
            }
        }
        return matrix;
    }
}
