package com.orbit.code.tree.lc04;

import com.orbit.code.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

public class Codec {

    String SEP = ",";
    String NULL = "#";

    //前序
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null ) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        serialize(root.left,sb);
        serialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(SEP)));
        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;
        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }


    //后序
    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    private void serialize1(TreeNode root, StringBuilder sb) {
        if (root == null ) {
            sb.append(NULL).append(SEP);
            return;
        }

        serialize(root.left,sb);
        serialize(root.right,sb);
        sb.append(root.val).append(SEP);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(SEP)));
        return deserialize(nodes);
    }

    private TreeNode deserialize1(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;
        String last = nodes.removeLast();
        if (last.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(last));
        root.right = deserialize(nodes);
        root.left = deserialize(nodes);
        return root;
    }

    //层序遍历
    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            TreeNode node = deque.poll();
            sb.append(node.val).append(SEP);
            if (node.left == null){
                sb.append(NULL).append(SEP);
            }else {
                deque.offer(node.left);
            }
            if (node.right == null){
                sb.append(NULL).append(SEP);
            }else {
                deque.offer(node.right);
            }
        }
        return sb.toString();
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        if (data.isEmpty())return null;
        String[] nodes = data.split(SEP);
        // 第一个元素就是 root 的值
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for(int i = 1; i < nodes.length;){
            TreeNode parent  = q.poll();
            String left = nodes[i++];
            if (!left.equals(NULL)){
                parent.left = new TreeNode(Integer.parseInt(left));
                q.offer(parent.left);
            }else {
                parent.left = null;
            }
            String right = nodes[i++];
            if (!right.equals(NULL)) {
                parent.right = new TreeNode(Integer.parseInt(right));
                q.offer(parent.right);
            } else {
                parent.right = null;
            }
        }
        return root;
    }


}
