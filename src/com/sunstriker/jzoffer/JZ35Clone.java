package com.sunstriker.jzoffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class JZ35Clone {
    public static void main(String[] args) {
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        a.next = b;
        b.next = c;
        a.random = c;
        b.random = a;
        print(a);
        RandomListNode res = Clone(a);
        print(res);
        System.out.println(usingOldNodes(a, res) );
        System.out.println(a == res);
    }

    public static boolean usingOldNodes(RandomListNode head1,RandomListNode head2){
        List<RandomListNode> set = new ArrayList<>();
        RandomListNode p = head1, p2=head2;
        while (p!=null){
            set.add(p);
            p=p.next;
        }
        while (p2!=null){
            if(set.contains(p2) ) {
                System.out.println("value: "+p2.label);
                return true;
            }
            if(set.contains(p2.random) ) {
                System.out.println("random: "+p2.label);
                return true;
            }
            p2=p2.next;
        }
        return false;
    }

    public static void print(RandomListNode head){
        RandomListNode p = head;
        List<Integer> res = new ArrayList<>();
        while (p!=null){
            res.add(p.label);
            p=p.next;
        }
        p=head;
        while (p!=null){
            if(p.random != null) res.add(p.random.label);
            else res.add(null);
            p=p.next;
        }
        System.out.println(res);
    }

    public static RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) return null;
        RandomListNode p = pHead;
        while (p != null) {
            RandomListNode temp = p.next;
            p.next = new RandomListNode(p.label);
            p.next.next = temp;
            p = temp;
        }
        p = pHead;
        while (p != null) {
            if (p.random != null) p.next.random = p.random.next;
            p = p.next.next;
        }
        p=pHead;
        RandomListNode res = pHead.next;
        while (p!=null) {
            RandomListNode temp = p.next.next;
            if (temp != null) p.next.next = temp.next;
            p.next=temp;
            p = temp;
        }
        return res;
    }
}
