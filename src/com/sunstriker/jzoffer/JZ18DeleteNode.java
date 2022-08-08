package com.sunstriker.jzoffer;

import com.sunstriker.structure.ListNode;

public class JZ18DeleteNode {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @param val int整型
     * @return ListNode类
     */
    public ListNode deleteNode (ListNode head, int val) {
        // write code here
        ListNode dummy = new ListNode(0), curr = head, prev;
        prev = dummy;
        dummy.next = head;
        while(curr!=null){
            if(curr.val == val){
                prev.next = curr.next;
                break;
            }
            prev = prev.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
