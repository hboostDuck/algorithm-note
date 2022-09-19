package com.orbit.code.backtrack;

import com.orbit.code.tree.TreeNode;

/**
 * @Author: orbit
 * @Date: 2022/09/14/18:26
 * @Description:
 */
public class LC112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null )return false;
        if (root.right == null&& root.left == null ){
            return root.val == targetSum;
        }
        return hasPathSum(root.left,targetSum-root.val)|| hasPathSum(root.right,targetSum-root.val);
    }
}
