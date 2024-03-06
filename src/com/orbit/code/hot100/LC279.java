package com.orbit.code.hot100;

/**
 * @Author: orbit
 * @Date: 2022/09/10/23:16
 * @Description:
 */
public class LC279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
//    public int numSquares2(int n) {
//        Queue<Integer> q = new LinkedList<>();
//        HashSet<Integer> visited = new HashSet<>();
//        q.offer(0);
//        visited.add(0);
//        int level = 0;
//        while (!q.isEmpty()){
//            int sz = q.size();
//            for (int i = 0; i < sz; i++) {
//                Integer poll = q.poll();
//                for (int j = 0; j *j <= n; j++) {
//
//                    q.offer()
//                }
//            }
//
//
//
//        }
//
//    }
}
