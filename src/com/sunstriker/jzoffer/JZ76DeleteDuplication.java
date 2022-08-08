package com.sunstriker.jzoffer;

import com.sunstriker.structure.ListNode;

public class JZ76DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        // 3个指针
        ListNode curr = pHead, prev, next = pHead.next, dummy = new ListNode(0);
        dummy.next = pHead;
        prev = dummy;
        boolean flag = false;
        while (curr != null) {
            if (next != null && curr.val == next.val) {
                if (!flag) {
                    flag = true;
                }

            } else {
                if (flag) {
                    prev.next = next;
                    flag = false;
                }else {
                    prev = prev.next;
                }
            }
            if (next != null) next = next.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
