package com.orbit.code.hot100;

import com.orbit.code.test.TEST;
import jdk.nashorn.internal.runtime.regexp.joni.constants.Traverse;
import sun.net.www.protocol.http.HttpURLConnection;

import javax.lang.model.element.VariableElement;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @Author: orbit
 * @Date: 2022/08/31/15:32
 * @Description:
 */
public class LC207 {

    boolean[] onPath;

    boolean[] visited;

    boolean hasCycle;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
       List<Integer>[] graph = buildGraph(numCourses,prerequisites);
       onPath = new boolean[numCourses];
       visited = new boolean[numCourses];
        for (int i = 0; i < graph.length; i++) {
            traverse(graph,i);
        }
        return !hasCycle;
    }

    private void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]){
            hasCycle = true;
        }
        if (visited[s] || hasCycle){
            return;
        }

        visited[s] = true;
        onPath[s] = true;
        for (Integer t : graph[s]) {
            traverse(graph,t);
        }
        onPath[s] = false;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] graph = new LinkedList[numCourses];
        for (LinkedList<Integer> list : graph) {
            list = new LinkedList<>();
        }
        for (int[] site : prerequisites) {
            int from = site[1], to = site[0];
            graph[from].add(to);
        }
        return graph;
    }
}
