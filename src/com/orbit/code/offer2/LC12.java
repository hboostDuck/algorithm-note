package com.orbit.code.offer2;

import java.time.Duration;
import java.util.concurrent.ThreadFactory;

public class LC12 {
    boolean[][] visited;
    StringBuilder path;
    public boolean exist(char[][] board, String word) {
        path = new StringBuilder();
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                return backtrack(board,word,i,j);
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j) {
        if(i <0 || j<0)return false;
        if (i>=board.length || j >= board[0].length) return false;
        if (word.equals(path.toString()))return true;

        path.append(board[i][j]);
        backtrack(board,word,i+1,j);
        path.deleteCharAt(path.length()-1);
        path.append(board[i][j]);
        backtrack(board,word,i-1,j);
        path.deleteCharAt(path.length()-1);
        path.append(board[i][j]);
        backtrack(board,word,i,j-1);
        path.deleteCharAt(path.length()-1);
        path.append(board[i][j]);
        backtrack(board,word,i,j+1);
        path.deleteCharAt(path.length()-1);
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
//        ThreadFactory vtf = Thread.ofVirtual().factory();
//        Thread thread = vtf.newThread(() -> {
//            System.out.println(Thread.currentThread().getName());
//        });
//        thread.start();
        Thread.startVirtualThread(()-> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("1111");
        });

        Thread.sleep(Duration.ofSeconds(1));

    }
}
