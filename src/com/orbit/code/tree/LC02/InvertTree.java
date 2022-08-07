package com.orbit.code.tree.LC02;

import com.orbit.code.tree.TreeNode;

//自顶向下
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        traverse(root.left);
        traverse(root.right);
    }

}
class InvertTree2 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);

        root.left = r;
        root.right = l;
        return root;
    }
}