package com.orbit.code.offer1;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.omg.CORBA.INTERNAL;

import java.util.PriorityQueue;

/**
 * @Author: orbit
 * @Date: 2022/09/13/0:52
 * @Description:
 */
public class LC41 {


}
class MedianFinder {

    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;
    /** initialize your data structure here. */
    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((a,b)->b-a);
    }

    public void addNum(int num) {
        if (large.size()<=small.size()){
            small.offer(num);
            large.offer(small.poll());
        }else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (large.size()> small.size()){
            return large.peek();
        }else if (large.size() < small.size()){
            return small.peek();
        }
        return (large.peek() + small.peek())/2.0;
    }
}