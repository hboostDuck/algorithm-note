package com.orbit.review2.hot.listnode;

import com.orbit.code.list.ListNode;

public class LC206 {
    public ListNode reverseList(ListNode head) {
        if ( head == null || head.next == null  ) return head;

        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
