package com.orbit.code.hot100;

import com.orbit.code.tree.TreeNode;

/**
 * @Author: orbit
 * @Date: 2022/09/12/16:47
 * @Description:
 */
public class LC124 {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return res;
    }

    private int oneSideMax(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0,oneSideMax(root.left));
        int right = Math.max(0,oneSideMax(root.right));
        int pathMaxSum = root.val + left + right;
        res = Math.max(res, pathMaxSum);
        return Math.max(left,right)+root.val;
    }
}
