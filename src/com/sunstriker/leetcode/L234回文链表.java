package com.sunstriker.leetcode;

import com.sunstriker.structure.ListNode;

public class L234回文链表 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        ListNode left = head;
        ListNode right = reverseFromAtoB(slow, null);
        while (right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
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
