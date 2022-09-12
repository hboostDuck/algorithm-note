package com.orbit.code.hot100;


import java.util.HashMap;
import java.util.List;

/**
 * @Author: orbit
 * @Date: 2022/09/12/22:26
 * @Description:
 */
public class LC399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        UF uf = new UF(2 * n);
        HashMap<String, Integer> map = new HashMap<>(2*n);
        int index =0;
        for (int i = 0; i < n; i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            if (!map.containsKey(s1)){
                map.put(s1,index++);
            }
            if (!map.containsKey(s2)){
                map.put(s2,index++);
            }
            uf.union(map.get(s1),map.get(s2),values[i]);
        }
        int querySize = queries.size();
        double[] res = new double[querySize];
        for (int i = 0; i <querySize; i++) {
            Integer i1 = map.get(queries.get(i).get(0));
            Integer i2 = map.get(queries.get(i).get(1));
            if (i1 == null || i2 == null){
                res[i] = -1.0d;
            }else {
                res[i] = uf.connected(i1,i2);
            }
        }
        return res;
    }
}

class UF{
    // k->v
    int[] parent;
    // k->v 权值
    double[] weight;
    public UF(int n) {
        parent = new int[n];
        weight = new double[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1.0d;
        }

    }

    public void union(Integer p, Integer q, double value) {
        int parentQ = find(q);
        int parentP = find(p);
        if (parentQ == parentP)
            return;
        parent[parentP] = parentQ;
        weight[parentP] = value * weight[parentQ]/weight[parentP];
    }

    private int find(int x){
        if (x != parent[x]) {
            int origin = parent[x];
            parent[x] = find(parent[x]);
            weight[x] *= weight[origin];
        }
        return parent[x];

    }

    public double connected(Integer p, Integer q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ){
            return weight[p]/weight[q];
        }else {
            return -1.0d;
        }

    }
}
class UnionFind {

    private int[] parent;

    /**
     * 指向的父结点的权值
     */
    private double[] weight;


    public UnionFind(int n) {
        this.parent = new int[n];
        this.weight = new double[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1.0d;
        }
    }

    public void union(int x, int y, double value) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }

        parent[rootX] = rootY;
        // 关系式的推导请见「参考代码」下方的示意图
        weight[rootX] = weight[y] * value / weight[x];
    }

    /**
     * 路径压缩
     *
     * @param x
     * @return 根结点的 id
     */
    public int find(int x) {
        if (x != parent[x]) {
            int origin = parent[x];
            parent[x] = find(parent[x]);
            weight[x] *= weight[origin];
        }
        return parent[x];
    }

    public double isConnected(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return weight[x] / weight[y];
        } else {
            return -1.0d;
        }
    }
}


