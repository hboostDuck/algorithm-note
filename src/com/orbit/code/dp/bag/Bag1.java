package com.orbit.code.dp.bag;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: orbit
 * @Date: 2022/09/06/12:11
 * @Description:
 */
public class Bag1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int goods = in.nextInt();
        int vul = in.nextInt();
        int[] wt = new int[goods];
        int[] val = new int[goods];
        for (int i = 0; i < goods; i++) {
            wt[i] = in.nextInt();
            val[i] = in.nextInt();
        }
        int[][] dp = new int[goods+1][vul+1];
        for (int i = 1; i <= goods; i++) {
            for (int j = 1; j <= vul; j++) {
                if (j - wt[i-1]<0){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1]);
                }
            }
        }
        System.out.println(dp[goods][vul]);

        int[] dp2 = new int[vul+1];
        Arrays.fill(dp2,Integer.MIN_VALUE);
        //没有物品时，价值为0
        dp2[0]=0;
        for (int i = 1; i <= goods; i++) {
            for (int j = vul; j >=wt[i-1]; j--) {
                dp2[j]=Math.max(dp2[j-wt[i-1]]+val[i-1],dp2[j]);
            }
        }
        //如果小于0，说明不能从初始状态转移过来，无解
        if(dp2[vul]<0){
            dp2[vul]=0;
        }
        System.out.println(dp2[vul]);
    }
}
