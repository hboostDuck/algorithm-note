package com.orbit.code.tree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root,p.val,q.val);
    }

    private TreeNode find(TreeNode root, int val, int val1) {
        if (root == null) return null;
        if (root.val == val || root.val == val1){
            return root;
        }
        TreeNode left = find(root.left, val, val1);
        TreeNode right = find(root.right, val, val1);
        if (left != null && right !=null ){
            return root;
        }
        return left !=null ? left:right;
    }
}
