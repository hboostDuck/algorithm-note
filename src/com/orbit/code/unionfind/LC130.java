package com.orbit.code.unionfind;

/**
 * @Author: orbit
 * @Date: 2022/09/12/20:33
 * @Description:
 */
public class LC130 {




    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        UF u = new UF(m * n + 1);
        int dummy = m*n;
        //首列和尾列
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O'){
                u.union(dummy,i*n);
            }
            if (board[i][n-1] == 'O'){
                u.union(dummy,i*n+n-1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O'){
                u.union(i,dummy);
            }
            if (board[m-1][i] == 'O'){
                u.union(n*(m-1)+i,dummy);
            }
        }
        // 方向数组 d 是上下左右搜索的常用手法
        int[][] d = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int i = 1; i < m - 1; i++)
            for (int j = 1; j < n - 1; j++)
                if (board[i][j] == 'O')
                    // 将此 O 与上下左右的 O 连通
                    for (int k = 0; k < 4; k++) {
                        int x = i+d[k][0];
                        int y = j+ d[k][1];
                        if (board[x][y] =='O')
                            u.union(x*n+y,i*n+j);
                    }
        // 所有不和 dummy 连通的 O，都要被替换
        for (int i = 1; i < m - 1; i++)
            for (int j = 1; j < n - 1; j++)
                if (!u.connected(dummy, i * n + j))
                    board[i][j] = 'X';
    }

}
//class UF{
//    int count;
//    int[] parent;
//    int[] size;
//    public UF(int n) {
//        this.count = n;
//        parent = new int[n];
//        size = new int[n];
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//            size[i] =1;
//        }
//    }
//
//    public void union(int p, int q){
//        int parentP = find(p);
//        int parentQ = find(q);
//        if (parentP != parentQ){
//            if (size[parentP] > size[parentQ]){
//                parent[parentQ] = parentP;
//                size[parentP]+= size[parentQ];
//            }else {
//                parent[parentP] = parentQ;
//                size[parentQ]+= size[parentP];
//            }
//            count--;
//        }
//    }
//
//    public boolean connected(int p,int q){
//        int parentP = find(p);
//        int parentQ = find(q);
//        return parentP == parentQ;
//    }
//    private int find(int x){
//        while (parent[x] != x){
//            parent[x] = find(parent[x]);
//        }
//        return parent[x];
//    }
//    public int count(){
//        return count;
//    }
//}