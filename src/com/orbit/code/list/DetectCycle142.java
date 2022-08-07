package com.orbit.code.list;

/**
 * @author hxy
 * @create 2022-04-10 21:06
 */
public class DetectCycle142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head,slow = head;
        while (fast!=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                int n = 0;
                ListNode p = head;
                while (p!= slow){
                    slow = slow.next;
                    p = p.next;
                    n++;
                }
                return new ListNode(n);
            };
        }
        return new ListNode(-1);
    }
}
