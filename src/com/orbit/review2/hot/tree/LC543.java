package com.orbit.review2.hot.tree;

import com.orbit.code.tree.TreeNode;

public class LC543 {

    int  diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left=0,right=0;
        if (root.left!=null) left = maxDepth(root.left);
        if (root.right!=null) right = maxDepth(root.right);

        diameter = Math.max(diameter, left+right);
        return Math.max(left,right)+1;
    }
}
