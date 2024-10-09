package com.orbit.review2.hot.listnode;

import com.orbit.code.list.ListNode;

public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 在两条链表上的指针
        ListNode p1 = l1, p2 = l2;
        // 虚拟头结点（构建新链表时的常用技巧）
        ListNode dummy = new ListNode(-1);
        // 指针 p 负责构建新链表
        ListNode p = dummy;
        // 记录进位
        int carry = 0;
        while (p1 != null || p2 != null || carry != 0) {
            if (p1 == null && p2 == null){
                p.next = new ListNode(carry);
                carry= 0;
            }else if (p1 == null){
                p.next = new ListNode((p2.val + carry)%10);
                carry = (p2.val + carry) / 10;
                p2 = p2.next;
            }else if (p2 == null){
                p.next = new ListNode((p1.val + carry)%10);
                carry = (p1.val + carry) / 10;
                p1 = p1.next;
            } else {
                p.next = new ListNode((p1.val + p2.val + carry)%10);
                carry = (p1.val + p2.val + carry) / 10;
                p2 = p2.next;
                p1 = p1.next;
            }
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        LC2 lc2 = new LC2();
        ListNode listNode = lc2.addTwoNumbers(l1, l2);
    }
}
