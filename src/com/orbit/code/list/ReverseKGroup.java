package com.orbit.code.list;

import java.awt.*;
import java.util.Stack;

/**
 * @author hxy
 * @create 2022-04-10 19:13
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        final ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode p = head;
        ListNode listNode = reverseKGroup(head, 4);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }
    static ListNode reverseKGroup(ListNode head,int k){
        final ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode l = dummy;
        final Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p !=null){
            stack.push(p);
            p = p.next;
            if (stack.size() == k){
                while (!stack.isEmpty()){
                    final ListNode pop = stack.pop();
                    l.next = pop;
                    pop.next = p;
                    l = l.next;
                }
            }

        }
        return dummy.next;
    }

/*    static ListNode reverseKGroup1(ListNode head,int k){
        final ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode p1 = head;
        while (p1 !=null){
            ListNode p2 =
        }

    }*/
}
