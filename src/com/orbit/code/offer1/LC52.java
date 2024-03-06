package com.orbit.code.offer1;

import com.orbit.code.list.ListNode;

/**
 * @Author: orbit
 * @Date: 2022/09/20/17:29
 * @Description:
 */
public class LC52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA,b = headB;
        while (a != b){
            if (a ==null){
                a = headA;
            }else {
                a = a.next;
            }
            if (b == null){
                b = headB;
            }else {
                b = b.next;
            }
        }
        return a;
    }
}
