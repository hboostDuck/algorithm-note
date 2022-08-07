package com.orbit.code.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hxy
 * @create 2022-04-17 11:30
 */
public class OpenLock752 {
    public static void main(String[] args) {

    }

    public int openLock1(String[] deadends, String target) {
        final ArrayDeque<String> q = new ArrayDeque<>();
        final HashSet<String> visited = new HashSet<>();
        for (String deadend : deadends) {
            visited.add(deadend);
        }
        q.offer("0000");
        visited.add("0000");
        int step =0;
        while (!q.isEmpty()){
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                final String cur = q.poll();
                if (cur.equals(target)) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    final String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    final String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }


    public int openLock2(String[] deadends, String target) {
          Set<String> deads = new HashSet<>();
     for (String s : deadends) deads.add(s);
     // 用集合不用队列，可以快速判断元素是否存在
     Set<String> q1 = new HashSet<>();
     Set<String> q2 = new HashSet<>();
     Set<String> visited = new HashSet<>();

     int step = 0;
     q1.add("0000");
     q2.add(target);

     while (!q1.isEmpty() && !q2.isEmpty()) {
         // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
         Set<String> temp = new HashSet<>();

         /* 将 q1 中的所有节点向周围扩散 */
         for (String cur : q1) {
             /* 判断是否到达终点 */
             if (deads.contains(cur))
                 continue;
             if (q2.contains(cur))
                 return step;

             visited.add(cur);

             /* 将一个节点的未遍历相邻节点加入集合 */
             for (int j = 0; j < 4; j++) {
                 String up = plusOne(cur, j);
                 if (!visited.contains(up))
                     temp.add(up);
                 String down = minusOne(cur, j);
                 if (!visited.contains(down))
                     temp.add(down);
             }
         }
         /* 在这里增加步数 */
         step++;
         // temp 相当于 q1
         // 这里交换 q1 q2，下一轮 while 就是扩散 q2
         q1 = q2;
         q2 = temp;
     }
     return -1;
    }


        public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>();
        HashSet<String> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }
        HashSet<String> q1 = new HashSet<>();
        HashSet<String> q2 = new HashSet<>();
        int step = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            HashSet<String> temp = new HashSet<>();
            for (String cur : q1) {
                if (deads.contains(cur)) {
                    continue;
                }
                if (q2.contains(cur)) {
                    return step;
                }

                /* 将一个节点的未遍历相邻节点加入集合 */
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        temp.add(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        temp.add(down);
                        visited.add(down);
                    }
                }
            }
            step++;
            q1 = q2;
            q2 = temp;
        }

        return -1;
    }

    String plusOne(String s,int j){
        char[] ch = s.toCharArray();
        if (ch[j] == '9'){
            ch[j] = '0';
        }else {
            ch[j] +=1;
        }
        return new String(ch);
    }
    String minusOne(String s,int j){
        char[] ch = s.toCharArray();
        if (ch[j] == '0'){
            ch[j] = '9';
        }else {
            ch[j] -=1;
        }
        return new String(ch);
    }
}
