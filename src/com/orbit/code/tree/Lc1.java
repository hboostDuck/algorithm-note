package com.orbit.code.tree;


public class Lc1 {
    // 记录最大深度
    int res = 0;
    // 记录遍历到的节点的深度
    int depth = 0;

    public int maxDepth(TreeNode root) {

        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        depth++;
        if (root.left == null && root.right == null) {
            res = Math.max(res,depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
