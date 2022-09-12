package com.orbit.code.hot100;

import com.orbit.code.tree.TreeNode;

/**
 * @Author: orbit
 * @Date: 2022/09/12/16:01
 * @Description:
 */
public class LC543 {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        track(root);
        return res;
    }

    private int track(TreeNode root) {
        if (root == null) return 0;
        int left = track(root.left);
        int right = track(root.right);
        res = Math.max(left+right,res);
        return Math.max(left,right)+1;
    }
}
