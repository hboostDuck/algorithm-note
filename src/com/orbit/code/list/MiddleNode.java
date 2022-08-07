package com.orbit.code.list;

/**
 * @author hxy
 * @create 2022-04-10 20:33
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head,slow = head;
        while (fast.next!=null && slow !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
