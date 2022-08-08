package com.sunstriker.jzoffer;

import com.sunstriker.structure.ListNode;

public class JZ24ReverseList {

    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null, curr = head, next = head.next;
        while (curr!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next!=null) next = next.next;
        }
        return prev;
    }
}
