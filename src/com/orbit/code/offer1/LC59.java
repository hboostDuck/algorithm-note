package com.orbit.code.offer1;

import java.util.LinkedList;

/**
 * @Author: orbit
 * @Date: 2022/09/07/14:45
 * @Description:
 */
public class LC59 {
}
class MaxQueue {

    LinkedList<Integer> maxq;
    LinkedList<Integer> q;
    public MaxQueue() {
        maxq = new LinkedList<>();
        q = new LinkedList<>();
    }

    public int max_value() {
        if (q.isEmpty()) return -1;
        return maxq.getFirst();
    }

    public void push_back(int value) {
        q.addLast(value);
        while (!maxq.isEmpty() && maxq.getLast() < value){
            maxq.pollLast();
        }
        maxq.addLast(value);
    }

    public int pop_front() {
        if (q.isEmpty()) return -1;
        Integer n = q.pollFirst();
        if(n.equals(maxq.getFirst())){
            maxq.pollFirst();
        }
        return n;
    }
}