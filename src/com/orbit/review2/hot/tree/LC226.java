package com.orbit.review2.hot.tree;

import com.orbit.code.tree.TreeNode;

public class LC226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left= root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
