package com.orbit.code.hot100;

import com.orbit.code.tree.TreeNode;


/**
 * @Author: orbit
 * @Date: 2022/08/31/18:41
 * @Description:
 */
public class LC538 {
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    int sum = 0;
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
