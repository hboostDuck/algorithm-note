package com.orbit.code.unionfind;

/**
 * @Author: orbit
 * @Date: 2022/09/12/21:12
 * @Description:
 */
public class LC990 {
    public boolean equationsPossible(String[] equations) {
        int n = equations.length;
        UF uf = new UF(26);
        for (String e : equations) {
            if (e.charAt(1) == '='){
                uf.union(e.charAt(0)-'a',e.charAt(3)-'a');
            }
        }
        for (String e : equations) {
            if (e.charAt(1) == '!'){
                if (uf.connected(e.charAt(0)-'a',e.charAt(3)-'a'))
                    return false;
            }
        }
        return true;
    }
}
class UF{
    int count;
    int[] parent;
    int[] size;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p,int q) {
        int parentP = find(p);
        int parentQ = find(q);
        if (parentP != parentQ){
            if (size[parentP] > size[parentQ]){
                parent[parentQ] = parentP;
                size[parentP] += size[parentQ];
            }else {
                parent[parentP] = parentQ;
                size[parentQ] += size[parentP];
            }
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int x){
        if (parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public int count(){
        return count;
    }
}