package com.sunstriker.jzoffer;


import com.sunstriker.structure.ListNode;

import java.util.ArrayList;

public class JZ6从尾到头打印链表 {
    public static void main(String[] args) {
//        System.out.println(3/2);
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res =  new ArrayList<>();
        while (listNode != null){
            res.add(listNode.val);
            listNode = listNode.next;
        }
        int temp = 0, size = res.size();
        for (int i = 0; i <= (size-1)/2; i++) {
            temp = res.get(i);
            res.set(i, res.get(size-1-i));
            res.set(size-1-i, temp);
        }

        return res;
    }
}
