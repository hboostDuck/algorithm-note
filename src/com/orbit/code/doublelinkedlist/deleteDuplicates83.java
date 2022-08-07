package com.orbit.code.doublelinkedlist;

import com.orbit.code.list.ListNode;

public class deleteDuplicates83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fast = head,slow = head;
        while (fast!=null){
            fast = fast.next;
            if (fast.val !=slow.val){
                slow.next = fast;
                slow=slow.next;
            }
        }
        return head;
    }
}
