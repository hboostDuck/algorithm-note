package com.orbit.code.design;

import java.util.Stack;

/**
 * @Author: orbit
 * @Date: 2022/08/26/20:47
 * @Description:
 */
public class MinStack {
    //记录所有元素
    Stack<Integer> stk = new Stack<>();
    //阶段性记录栈中最小的元素
    Stack<Integer> minStk = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        stk.push(val);
        if (minStk.isEmpty() || val <= minStk.peek()){
            minStk.push(val);
        }
    }

    public void pop() {
        Integer pop = stk.pop();
        if (pop.equals(minStk.peek())){
            minStk.pop();
        }
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return minStk.peek();
    }
}
