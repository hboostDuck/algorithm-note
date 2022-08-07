package com.orbit.code.tree;

import java.util.*;

/**
 * @author hxy
 * @create 2022-04-14 21:52
 */
public class MinDepth {

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(root);
        visited.add(root);
        int step = 0;
        while (!q.isEmpty()) {
            final int size = q.size();
            for (int i = 0; i < size; i++) {
                final TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null){
                    return step+1;
                }
                if (!visited.contains(cur.left)){
                    q.offer(cur.left);
                }
                if (!visited.contains(cur.right)){
                    q.offer(cur.right);
                }
            }
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(3,
                new TreeNode(9, null, null),
                new TreeNode(20,
                        new TreeNode(15, null, null),
                        new TreeNode(6, null, null)));
        final int i = minDepth(root);

        System.out.println(i);

//        Queue<TreeNode> q = new ArrayDeque<>();
//        q.offer(null);
    }

}
