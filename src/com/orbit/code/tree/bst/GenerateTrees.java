package com.orbit.code.tree.bst;

import com.orbit.code.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        return gen(1,n);
    }

    private List<TreeNode> gen(int lo, int hi) {
        LinkedList<TreeNode> list = new LinkedList<>();
        if (lo > hi){
           list.add(null);
           return list;
        }
        for (int i = lo; i <=hi; i++) {
            List<TreeNode> left = gen(lo,i-1);
            List<TreeNode> right = gen(i+1,hi);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
