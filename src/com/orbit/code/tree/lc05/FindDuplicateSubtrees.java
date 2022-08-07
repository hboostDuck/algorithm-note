package com.orbit.code.tree.lc05;

import com.orbit.code.tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

    Map<String,Integer> subTree = new HashMap<>();

    List<TreeNode> res = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }
    private String serialize(TreeNode root) {
        if (root == null) return "#";
        String left = serialize(root.left);
        String right = serialize(root.right);

        String myself = left+ "," + right + "," + root.val;
        Integer freq = subTree.getOrDefault(myself, 0);
        if (freq == 1){
            res.add(root);
        }
        subTree.put(myself,freq+1);
        return myself;
    }
}
