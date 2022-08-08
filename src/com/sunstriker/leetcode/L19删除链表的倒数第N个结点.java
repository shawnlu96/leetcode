package com.sunstriker.leetcode;

import com.sunstriker.structure.ListNode;

public class L19删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next  = head;
        ListNode curr = dummy;
        ListNode nextN = dummy;
        for (int i = 0; i < n; i++) {
            nextN = nextN.next;
        }
        while (nextN!=null){
            curr = curr.next;
            nextN =  nextN.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
}
