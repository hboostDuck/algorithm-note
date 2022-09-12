package com.orbit.code.list;

/**
 * @Author: orbit
 * @Date: 2022/09/13/0:30
 * @Description:
 */
public class LC86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode a = new ListNode(-1),b = new ListNode(-1);
        ListNode p =a, q = b;
        while (head!= null){
            if (head.val >= x){
                b.next = head;
                b= b.next;
            }else {
                a.next = head;
                a = a.next;
            }
            head = head.next;
        }

        b.next = null;
        a.next = q.next;
        return p.next;
    }
}
