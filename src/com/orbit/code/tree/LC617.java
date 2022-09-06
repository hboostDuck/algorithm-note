package com.orbit.code.tree;

/**
 * @Author: orbit
 * @Date: 2022/08/26/20:10
 * @Description:
 */
public class LC617 {
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1,root2);
    }

    private static TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return null;
        }
        TreeNode root = null;
        if (root1 != null && root2 != null){
            root = new TreeNode(root1.val+ root2.val);
            root.left = dfs(root1.left,root2.left);
            root.right = dfs(root1.right,root2.right);
        }else if (root1 != null){
            root = new TreeNode(root1.val);
            root.left = dfs(root1.left,null);
            root.right = dfs(root1.right,null);
        }else {
            root = new TreeNode(root2.val);
            root.left = dfs(null,root2.left);
            root.right = dfs(null,root2.right);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1,
                new TreeNode(3, new TreeNode(5), null),
                new TreeNode(2));
        TreeNode r2 = new TreeNode(2,
                new TreeNode(1, null, new TreeNode(4)),
                new TreeNode(3, null, new TreeNode(7)));
        mergeTrees(r1,r2);
    }
}
