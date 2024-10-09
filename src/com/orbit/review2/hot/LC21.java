package com.orbit.review2.hot;

import com.orbit.code.list.ListNode;

public class LC21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p ,q;
        p = list1;
        q = list2;
        ListNode r = new ListNode(-1);
        ListNode cur = r;
        while(p != null && q != null){
            if (p.val < q.val ){
                cur.next = p;
                p = p.next;
            }else {
                cur.next = q;
                q = q.next ;
            }
            cur = cur.next;
        }
        if (p!=null) cur.next = p;
        if (q!= null) cur.next = q;
        return r.next;
    }
}
