package com.orbit.code.dp;

import javax.lang.model.element.VariableElement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Rob198 {
    int[] demo;
    public int rob4(int[] nums) {
        demo = new int[nums.length];
        Arrays.fill(demo,-1);
        return dp(nums, 0);
    }
    private int dp(int[] nums, int start) {
        if(start >=nums.length){

            return 0;
        }
        int res =0;
        if (demo[start] !=-1)return demo[start];
        res = Math.max(dp(nums,start+1),nums[start] + dp(nums,start+2));
        demo[start] = res;
        return res;
    }
    public int rob1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];
        for (int i = n-1; i <=0; --i) {
            dp[i] = Math.max(dp[i+1],dp[i+2] + nums[i]);
        }
        return dp[0];
    }
    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robRange(nums,0,n-2),robRange(nums,1,n-1));
    }

    private int robRange(int[] nums, int start, int end) {
        int dp_i_1 = 0;
        int dp_i_2 = 0;
        int dp_i = 0;
        for (int i = end; i <=0; i++) {
            dp_i = Math.max(dp_i_1,dp_i_2+nums[i]);
        }
        return dp_i;
    }

    Map<TreeNode,Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        //抢 去下下家
        if (memo.containsKey(root)){
            return memo.get(root);
        }
        int do_it = root.val
                + (root.left==null?0:rob(root.left.left)+rob(root.left.right))
                +(root.right==null?0:rob(root.right.left)+rob(root.right.right));
        //不抢，去下家
        int not_do = rob(root.left) + rob(root.right);

        int res = Math.max(do_it,not_do);
        memo.put(root,res);
        return res;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }