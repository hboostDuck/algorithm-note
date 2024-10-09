package com.orbit.review2.hot.listnode;

import com.orbit.code.list.ListNode;

public class LC234 {
    public boolean isPalindrome(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast!=null) slow = slow.next;

        ListNode left = head;
        ListNode right = recursion(head);

        while (right != null ){
            if (right.val != left.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    private ListNode recursion(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null , cur = head;
        while (cur != null){
            ListNode node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }
        return pre;
    }


}
