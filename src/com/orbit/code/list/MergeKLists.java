package com.orbit.code.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hxy
 * @create 2022-04-09 22:05
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(l -> l.val));
        for (ListNode head : lists) {
            if (head!=null){
                queue.add(head);
            }
        }

        while (!queue.isEmpty()){
            final ListNode poll = queue.poll();
            p.next = poll;
            if (poll.next!=null){
                queue.offer(poll.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
