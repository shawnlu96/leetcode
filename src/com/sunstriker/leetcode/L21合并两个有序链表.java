package com.sunstriker.leetcode;

import com.sunstriker.structure.ListNode;

public class L21合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (list1!=null || list2!= null) {
            if(list1 == null) {
                curr.next = list2;
                break;
            }
            else if(list2 == null) {
                curr.next = list1;
                break;
            }
            else if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr= curr.next;
        }
        return dummy.next;
    }
}
