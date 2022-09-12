package com.orbit.code.offer1;

import com.orbit.code.list.ListNode;

/**
 * @Author: orbit
 * @Date: 2022/09/12/23:59
 * @Description:
 */
public class LC18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode r = dummy;
        ListNode p = head;
        while (p != null){
            if (p.val != val){
                r.next = p;
                r = r.next;
            }
            p= p.next;
        }
        return dummy.next;
    }
}
