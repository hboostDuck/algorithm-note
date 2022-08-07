package com.orbit.code.tree.LC02;

public class Connect {
    public Node connect(Node root) {
        if (root == null) return root;
        traverse(root.left,root.right);
        return root;

    }

    private void traverse(Node left, Node right) {
        if (left == null || right == null){
            return;
        }
        traverse(left.left,left.right);
        traverse(right.left,right.right);
        traverse(left.right,right.left);
        left.next = right;
    }
}




class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};