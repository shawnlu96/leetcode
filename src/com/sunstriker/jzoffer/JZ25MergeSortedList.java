package com.sunstriker.jzoffer;

import com.sunstriker.structure.ListNode;

public class JZ25MergeSortedList {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode temp = null;
        while (list1 != null || list2 != null) {
            if(list1 == null) {
                curr.next = list2;
                break;
            }
            if(list2 == null){
                curr.next = list1;
                break;
            }
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}

