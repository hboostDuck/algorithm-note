package com.orbit.code.tree.LC03;



public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return build(nums,0,nums.length-1);
    }

    private TreeNode build(int[] nums, int lo, int hi) {
        if (lo>hi){
            return null;
        }

        int index = -1 , maxVal = Integer.MIN_VALUE;
        for (int i = 0; i <= hi; i++) {
            if (maxVal < nums[i]){
                index = i;
                maxVal = nums[i];
            }
        }
        TreeNode node = new TreeNode(maxVal);
        node.left = build(nums, lo, index - 1);
        node.right = build(nums, index + 1, hi);
        return node;

    }
}
class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}