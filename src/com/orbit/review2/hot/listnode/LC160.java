package com.orbit.review2.hot.listnode;

import com.orbit.code.list.ListNode;

public class LC160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        LC160 lc160 = new LC160();
        ListNode a = new ListNode(2, new ListNode(6, new ListNode(4)));
        ListNode b = new ListNode(1, new ListNode(5));
        lc160.getIntersectionNode(a,b);
    }
}
