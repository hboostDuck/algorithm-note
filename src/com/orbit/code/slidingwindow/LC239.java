package com.orbit.code.slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: orbit
 * @Date: 2022/09/07/0:18
 * @Description:
 */
public class LC239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k-1){
                window.push(nums[i]);
            }else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
class MonotonicQueue {

    // 双链表，支持头部和尾部增删元素
// 维护其中的元素自尾部到头部单调递增
    private LinkedList<Integer> maxq = new LinkedList<>();
    // 在队尾添加元素 n
    void push(int n){
        while (!maxq.isEmpty()&& maxq.getLast()< n ){
            maxq.pollLast();
        }
        maxq.addLast(n);
    };
    // 返回当前队列中的最大值
    int max(){
        return maxq.getFirst();
    };
    // 队头元素如果是 n，删除它
    void pop(int n){
        if (n == maxq.getFirst()){
            maxq.pollFirst();
        }
    };
}