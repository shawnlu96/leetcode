package com.sunstriker.leetcode;

import com.sunstriker.structure.ListNode;

public class L92反转链表II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (right - left < 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy, prev = null, next = head;
        ListNode last = null;
        for (int i = 0; i <= left; i++) {
            if (i == left) last = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        for (int i = 0; i < right - left; i++) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next == null ? null : next.next;
        }

        last.next.next = curr;
        last.next = prev;

        return dummy.next;

    }
}
