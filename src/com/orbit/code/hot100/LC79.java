package com.orbit.code.hot100;

/**
 * @Author: orbit
 * @Date: 2022/09/04/14:48
 * @Description:
 */
public class LC79 {

    private boolean find;
    public boolean exist(char[][] board, String word) {
        int m = board.length,n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtrack(board,i,j,word,0);
                if (find) return true;
            }
        }
        return find;
    }

    private void backtrack(char[][] board, int i, int j, String word, int index) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] == '.' || board[i][j]!= word.charAt(index)){
            return;
        }
        //递归边界2:当前字符匹配成功,且已经匹配到word单词的最后一个字母
        if(index == word.length() - 1){
            find = true;
            return;
        }
        char temp = board[i][j];
        board[i][j] = '.';
        //向四个方向递归
        backtrack(board, i + 1, j, word, index + 1);
        backtrack(board, i - 1, j, word, index + 1);
        backtrack(board, i, j + 1,word, index + 1);
        backtrack(board,i, j - 1, word, index + 1);
        board[i][j] = temp;
    }

}
