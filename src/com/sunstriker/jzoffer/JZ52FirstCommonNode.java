package com.sunstriker.jzoffer;

import com.sunstriker.structure.ListNode;

public class JZ52FirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1, p2 = pHead2;
        int length1 = 0, length2 = 0;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                p1 = p1.next;
                length1++;
            }
            if (p2 != null) {
                p2 = p2.next;
                length2++;
            }
        }
        p1 = pHead1;
        p2 = pHead2;
        if (length1 > length2) {
            for (int i = 0; i < length1 - length2; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < length2 - length1; i++) {
                p2 = p2.next;
            }
        }
        while(p1 != null) {
            if(p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
