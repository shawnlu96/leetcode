package com.sunstriker.leetcode;

import com.sunstriker.structure.ListNode;

public class L83删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = null, curr = head, finder = head;
        while (finder!=null){
            if(finder.val!= curr.val){
                curr.next = finder;
                pre = curr;
                curr = curr.next;
            }
            if(finder.next == null) pre.next = null;
            finder = finder.next;
        }
        return head;
    }
}
