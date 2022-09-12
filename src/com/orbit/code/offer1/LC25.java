package com.orbit.code.offer1;

import com.orbit.code.list.ListNode;

/**
 * @Author: orbit
 * @Date: 2022/09/13/0:08
 * @Description:
 */
public class LC25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val ){
                p.next = l2;
                l2 = l2.next;
            }else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        p.next = l1 == null? l2:l1;
        return dummy.next;
    }
}
