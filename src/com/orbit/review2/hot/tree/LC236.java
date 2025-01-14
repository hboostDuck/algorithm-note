package com.orbit.review2.hot.tree;

import com.orbit.code.tree.TreeNode;

public class LC236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 情况 1
        if (left != null && right != null) { return root; }
        // 情况 2
        if (left == null && right == null) { return null; }
        // 情况 3
        return left == null ? right : left;

    }
}
