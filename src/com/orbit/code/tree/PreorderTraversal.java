package com.orbit.code.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hxy
 * @create 2022-04-07 19:13
 */
public class PreorderTraversal {
    List<Integer> list = new ArrayList<>();

    //递归
    public List<Integer> preorderTraversal1(TreeNode root) {
        preTraversal(root);
        return list;
    }

    void preTraversal(TreeNode root){
        if (root == null) return;
        list.add(root.val);
        preTraversal(root.left);
        preTraversal(root.right);
    }
    //迭代

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
    }
}
