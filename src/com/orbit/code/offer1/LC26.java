package com.orbit.code.offer1;

import com.orbit.code.tree.TreeNode;


/**
 * @Author: orbit
 * @Date: 2022/09/21/16:52
 * @Description:
 */
public class LC26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if(A == null ) return false;
        if (A.val == B.val && traverse(A, B)){
            return true;
        }
        return isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    private boolean traverse(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null){
            return false;
        }
        if (a.val != b.val){
           return false;
        }
        return traverse(a.left,b.left) && traverse(a.right,b.right);
    }
}
