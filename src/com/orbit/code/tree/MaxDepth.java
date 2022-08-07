package com.orbit.code.tree;

/**
 * @author hxy
 * @create 2022-04-09 22:06
 */
public class MaxDepth {

    int depth;
    int ans;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null){
            ans= Math.max(ans, depth);
            return;
        }
        // 前序位置
        depth++;
        traverse(root.left);
        traverse(root.right);
        // 后序位置
        depth--;
    }

    public int maxDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }else {
            final int l = maxDepth1(root.left);
            final int r = maxDepth1(root.right);
            return Math.max(l,r)+1;
        }
    }
}
