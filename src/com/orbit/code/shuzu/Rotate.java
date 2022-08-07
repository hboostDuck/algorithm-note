package com.orbit.code.shuzu;

public class Rotate {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int[] ints : matrix) {
            int l = 0,r = ints.length;
            while (l<r){
                int tmp = ints[l];
                ints[l] = ints[r];
                ints[r] = tmp;
                l++;
                r--;
            }
        }

    }
}
