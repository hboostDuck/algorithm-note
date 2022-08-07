package com.orbit.code.tree.LC03;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class BuildTree2 {
    Map<Integer,Integer> valToIndex =  new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    TreeNode build(int[] inorder, int inStart, int inEnd,
                   int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) return null;
        int rootVal = postorder[postEnd];
        Integer index = valToIndex.get(rootVal);
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder,inStart,index-1,
                        postorder,postStart,postStart+leftSize);
        root.right = build(inorder,index+1, inEnd,
                        postorder,postStart+leftSize+1,postEnd-1);
        return root;
    }
}
