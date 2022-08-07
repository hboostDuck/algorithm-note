package com.orbit.code.tree.LC02;

import com.orbit.code.tree.TreeNode;

import javax.xml.stream.FactoryConfigurationError;

public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null ) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;

        TreeNode c = root;
        while (c.right != null){
            c = c.right;
        }
        c.right = right;
    }


}
