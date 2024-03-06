package com.orbit.code.hot100;

import com.orbit.code.list.ListNode;

import java.util.PriorityQueue;

/**
 * @Author: orbit
 * @Date: 2022/09/11/23:58
 * @Description:
 */
public class LC148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head.next,slow = head;
        while (fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        return merge(left,right);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l != null && r!= null){
            if (l.val <= r.val){
                p.next = l;
                l = l.next;
            }else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        if (l != null){
            p.next = l;
        }
        if (r != null){
            p.next = r;
        }
        return head.next;
    }


    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode fast = head.next, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode tmp = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(tmp);
            return getListNode(left, right);
        }

        private ListNode getListNode(ListNode left, ListNode right) {
            ListNode h = new ListNode(0);
            ListNode res = h;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    h.next = left;
                    left = left.next;
                } else {
                    h.next = right;
                    right = right.next;
                }
                h = h.next;
            }
            h.next = left != null ? left : right;
            return res.next;
        }
    }

    public ListNode sortList1(ListNode head) {
        if (head == null) return null;

        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b)-> a.val -b.val);
        ListNode p = head;
        while (p != null){
            q.offer(p);
            p = p.next;
        }
        ListNode res = q.poll();
        ListNode h = res;
        while (!q.isEmpty()) {
            h.next = q.poll();
            h = h.next;
        }
        h.next =null;
        return res;
    }
}
