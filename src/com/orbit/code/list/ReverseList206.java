package com.orbit.code.list;

/**
 * @author hxy
 * @create 2022-04-10 21:46
 */
public class ReverseList206 {
    public ListNode reverseList(ListNode head) {
        if (head== null || head.next ==null){
            return head;
        }
        final ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    ListNode successor = null; // 后驱节点
    ListNode reverseN(ListNode head, int n) {
        if(n == 1){
            successor = head.next;
            return head;
        }
        final ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
