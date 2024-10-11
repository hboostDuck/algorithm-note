package com.orbit.review2.hot.tree;


import com.orbit.code.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC94 {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root,res);
        return res;
    }

    private void traversal(TreeNode root,List<Integer> res) {
        if (root == null) return;
        traversal(root.left,res);
        res.add(root.val);
        traversal(root.right,res);
    }
}
