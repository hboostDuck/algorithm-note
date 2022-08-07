package com.orbit.code.backtrack;

public class LC37 {
    public void solveSudoku(char[][] board) {
        backtrack(board,0,0);
    }

    private boolean backtrack(char[][] board, int i, int j) {
        int m = 9,n = 9;
        if (j == n){
            return backtrack(board,i+1,0);
        }
        if (i == m){
            return true;
        }
        if (board[i][j] != '.') {
           return backtrack(board, i, j+1);
        }
        for (char ch = '1'; ch <= '9'; ch++) {
            if (!isValid(board, i, j, ch)){
                continue;
            }
            board[i][j] = ch;
            if (backtrack(board, i, j+1)){
                return true;
            }
            board[i][j] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j, char ch) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == ch) {
                return false;
            }
            if (board[k][j] == ch){
                return false;
            }
            if (board[(i/3)*3 + k/3][(j/3)*3 + k%3] == ch)
                return false;
        }
        return true;
    }
}
