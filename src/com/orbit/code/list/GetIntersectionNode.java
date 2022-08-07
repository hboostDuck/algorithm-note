package com.orbit.code.list;

/**
 * @author hxy
 * @create 2022-04-10 20:39
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA,p2 = headB;
        while (p1!=p2){
            if (p1 == null) {p1= headA;}else {p1 = p1.next;};
            if (p2 == null) {p2 = headB;}else {p2 = p2.next;};
        }
        return p1;
    }
}
