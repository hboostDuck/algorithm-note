package com.orbit.code.tree;

/**
 * @author hxy
 * @create 2022-04-14 21:26
 */
public class DiameterOfBinaryTree543 {
    int mDepth =0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return mDepth;
    }

    int maxDepth(TreeNode root){
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        mDepth = Math.max(mDepth,l+r);
        return 1 + Math.max(l,r);
    }

}
