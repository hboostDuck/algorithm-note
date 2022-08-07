package com.orbit.code.graph;

import java.util.LinkedList;
import java.util.List;

public class AllPathsSourceTarget {
   List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph,0,path);
        return res;
    }

    private void traverse(int[][] graph, int i, LinkedList<Integer> path) {
        //base case
        path.addLast(i);
        if (i == graph.length-1){
            res.add(new LinkedList<>(path));
        }
        for (int i1 : graph[i]) {
            traverse(graph, i1, path);
        }
        path.removeLast();
    }
}
