package com.orbit.code.list;

import java.lang.annotation.Retention;

/**
 * @author hxy
 * @create 2022-04-11 17:17
 */
public class LC234 {
    ListNode left = null;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return reverse(head);
    }

    private boolean reverse(ListNode head) {
        if (head == null) return true;
        boolean flag = reverse(head.next);
        if (flag){
            flag = left.val == head.val;
        }
        left = left.next;
        return flag;
    }

}
