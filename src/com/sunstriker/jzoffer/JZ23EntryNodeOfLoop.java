package com.sunstriker.jzoffer;

import com.sunstriker.structure.ListNode;

public class JZ23EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode p1 = pHead, p2 = pHead;
        while (p1 != null) {
            p1 = p1.next;
            if (p1 == null) return null;
            p2 = p2.next.next;
            if (p2 == null) return null;
            if (p1 == p2) break;
        }
        if (p1 == null) return null;
        int length = 1;
        ListNode p = p1.next;
        if (p == p1) return p;
        while (p != p1) {
            length++;
            p = p.next;
        }
        while (true) {
            ListNode temp = pHead;
            for (int i = 0; i < length; i++) {
                temp = temp.next;
            }
            if (temp == pHead) return pHead;
            pHead = pHead.next;
        }
    }
}
