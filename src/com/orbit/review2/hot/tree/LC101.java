package com.orbit.review2.hot.tree;

import com.orbit.code.dfs.RestoreIpAddresses;
import com.orbit.code.tree.TreeNode;

public class LC101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)return true;
        return  isSym(root.left,root.right) ;
    }

    private boolean isSym(TreeNode root1, TreeNode root2) {
        if (root1==null && root2 == null) return true;
        if (root1==null || root2 == null) return false;

        return (root1.val == root2.val) && isSym(root1.left,root2.right) && isSym(root1.right,root2.left);
    }
}
