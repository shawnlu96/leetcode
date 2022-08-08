package com.sunstriker.leetcode;

import com.sunstriker.structure.ListNode;

public class L25K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode a ,b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if(b == null) return head;
            b = b.next;
        }
        ListNode reversedHead = reverseFromAtoB(a,b);
        a.next = reverseKGroup(b, k);
        return reversedHead;
    }

    // reverse [a,b)
    public ListNode reverseFromAtoB(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, next = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
