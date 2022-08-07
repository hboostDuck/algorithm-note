package com.orbit.code.tree;

public class Flatten {

    public void flatten(TreeNode root) {

        traverse(root);
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left.right = tmp;
        traverse(root .left);
        traverse(root.right);
    }

}
