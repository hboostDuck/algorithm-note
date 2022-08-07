package com.orbit.code.backtrack.island;

public class LC1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1){
                    dfs(grid2,i,j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1){
                    res++;
                }
                dfs(grid2,i,j);
            }
        }
        return res;
    }

    private void dfs(int[][] grid2, int i, int j) {
        int m = grid2.length;
        int n = grid2[0].length;
        if (i < 0 || j < 0 || i >= m || j >=n) {
            return;
        }
        if (grid2[i][j] == 0){
            return;
        }
        grid2[i][j] = 0;
        dfs(grid2, i+1, j);
        dfs(grid2, i-1, j);
        dfs(grid2, i, j+1);
        dfs(grid2, i, j-1);
    }
}
