package com.orbit.code.tree;

import java.awt.event.HierarchyBoundsAdapter;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
    private Iterator<Integer> it;
    public NestedIterator(List<NestedInteger> nestedList) {
        LinkedList<Integer> result = new LinkedList<>();
        for (NestedInteger node : nestedList) {
            traverse(node,result);
        }
        this.it = result.iterator();
    }

    private void traverse(NestedInteger node, LinkedList<Integer> result) {
        if (node.isInteger()){
            result.add(node.getInteger());
            return;
        }
        for (NestedInteger nestedInteger : node.getList()) {
            traverse(nestedInteger,result);
        }
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}
class NestedIterator1 implements Iterator<Integer> {
    LinkedList<NestedInteger> list;
    public NestedIterator1(List<NestedInteger> nestedList) {
        list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
       return list.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!list.isEmpty() && !list.get(0).isInteger()){
            List<NestedInteger> first = list.remove(0).getList();
            for (int i = first.size()-1; i >=0; i--) {
                list.addFirst(first.get(i));
            }
        }
        return !list.isEmpty();
    }
}
