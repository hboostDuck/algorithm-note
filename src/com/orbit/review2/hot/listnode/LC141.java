package com.orbit.review2.hot.listnode;

import com.orbit.code.list.ListNode;

public class LC141 {

    public boolean hasCycle(ListNode head) {

        ListNode fast = head ,slow = head;
        while(fast!= null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
