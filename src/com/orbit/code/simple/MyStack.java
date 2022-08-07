package com.orbit.code.simple;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack {
    Deque<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        return queue.removeLast();
    }

    public int top() {
        return queue.peekLast();
    }

    public boolean empty() {
       return queue.isEmpty();
    }
}
