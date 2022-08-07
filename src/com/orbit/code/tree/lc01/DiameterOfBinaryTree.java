package com.orbit.code.tree.lc01;

import com.orbit.code.tree.TreeNode;

public class DiameterOfBinaryTree {
    int mPath = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxPath(root);
        return mPath;
    }
    private int maxPath(TreeNode root) {
        if (root == null) return 0;
        int l = maxPath(root.left);
        int r = maxPath(root.right);
        mPath = Math.max(mPath,l+r);
        return 1+Math.max(l,r);
    }
}
