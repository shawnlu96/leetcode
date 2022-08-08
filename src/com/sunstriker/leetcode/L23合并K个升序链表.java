package com.sunstriker.leetcode;

import com.sunstriker.structure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class L23合并K个升序链表 {
    public static void main(String[] args) {
        new L23合并K个升序链表().mergeKLists(new ListNode[]{new ListNode(1),new ListNode(1),new ListNode(1),new ListNode(1),new ListNode(1),new ListNode(1),new ListNode(1)});
    }
    public ListNode mergeKListsPQ(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(l -> l.val));
        for (ListNode list : lists) {
            pq.offer(list);
        }
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) pq.offer(cur.next);
        }
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int n = 1;
        while (n < lists.length) {
            for (int i = 0; i + n < lists.length; i += 2 * n) {
                lists[i] = mergeTwoLists(lists[i], lists[i + n]);
            }
            n *= 2;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                curr.next = list2;
                break;
            } else if (list2 == null) {
                curr.next = list1;
                break;
            } else if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
