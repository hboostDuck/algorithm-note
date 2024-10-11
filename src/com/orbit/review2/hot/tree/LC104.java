package com.orbit.review2.hot.tree;

import com.orbit.code.tree.TreeNode;

public class LC104 {


    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
