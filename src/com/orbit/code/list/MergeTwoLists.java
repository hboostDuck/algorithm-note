package com.orbit.code.list;

/**
 * @author hxy
 * @create 2022-04-09 21:54
 */
public class MergeTwoLists {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        final ListNode dummy = new ListNode(-1);
        ListNode p1 = list1,p2 = list2;
        ListNode p = dummy;
        while (p1!=null && p2 !=null){
            if (p1.val > p2.val){
                p.next = p2;
                p1 = list1.next;
            }else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        if (list1!=null){
            p.next = list1;
        }
        if (list2 !=null){
            p.next = list2;
        }
        return dummy.next;
    }
}
