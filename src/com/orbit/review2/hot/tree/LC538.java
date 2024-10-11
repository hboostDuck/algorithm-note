package com.orbit.review2.hot.tree;

import com.orbit.code.tree.TreeNode;

public class LC538 {
    public TreeNode convertBST(TreeNode root) {

        convert(root);
        return root;
    }
    int sum = 0;
    private void convert(TreeNode root) {
        if (root == null) return;
        convert(root.right);
        sum += root.val;
        root.val = sum ;
        convert(root.left);
    }
}
