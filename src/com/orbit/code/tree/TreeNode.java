package com.orbit.code.tree;

/**
 * @author hxy
 * @create 2022-04-07 19:12
 */
public class TreeNode {

 public int val;
 public TreeNode left;
 public TreeNode right;

 public TreeNode() {
 }

 public TreeNode(int val) {
  this.val = val;
 }

 public TreeNode(int val, TreeNode left, TreeNode right) {
  this.val = val;
  this.left = left;
  this.right = right;
 }

}
