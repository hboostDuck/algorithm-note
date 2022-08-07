package com.orbit.code.list;

/**
 * @author hxy
 * @create 2022-04-10 20:23
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        final ListNode nthFromEndNode = findFromEnd(head, n+1);
        nthFromEndNode.next = nthFromEndNode.next.next;
        return dummy.next;
    }

    public ListNode findFromEnd(ListNode head, int n){
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }


}
