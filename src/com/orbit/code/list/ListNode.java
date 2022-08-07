package com.orbit.code.list;

/**
 * @author hxy
 * @create 2022-04-09 21:54
 */
public class ListNode {
      public int val;
      public ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }