package com.orbit.code.tree.LC03;

import java.util.HashMap;

public class ConstructFromPrePost {
    // 存储 postorder 中值到索引的映射
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i],i);
        }
        return build(preorder,0,preorder.length-1,
                    postorder,0,postorder.length-1);

    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int PostStart, int PostEnd) {
        if (preStart >preEnd)return null;
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int rootVal = preorder[preStart];
        int leftRootVal = preorder[preStart + 1];
        Integer index = valToIndex.get(leftRootVal);
        int leftSize = index - PostStart+1;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder,preStart+1,preStart+leftSize,
                        postorder,PostStart,index);
        root.right = build(preorder,preStart+leftSize+1,preEnd,
                        postorder,index+1,PostEnd-1);
        return root;
    }
}
