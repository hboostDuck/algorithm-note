package com.orbit.code.tree.LC03;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    Map<Integer,Integer> valToIndex =  new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        Integer index = valToIndex.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - preStart;
        root.left = build(preorder,preStart+1,preStart+leftSize,
                        inorder,inStart,index-1);
        root.right = build(preorder,preStart+leftSize+1,preEnd,
                        inorder,index+1,inEnd);
        return root;
    }
}
