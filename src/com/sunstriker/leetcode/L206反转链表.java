package com.sunstriker.leetcode;

import com.sunstriker.structure.ListNode;

public class L206反转链表 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode reversed = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }
}
