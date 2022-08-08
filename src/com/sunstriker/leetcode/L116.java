package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class L116 {


    public static void main(String[] args) {
        var root = new ArrayList<Integer>();
        root.set(0,1);
        root.set(2,1);
    }

    public Node connectPerfect(Node root) {
        if (root == null || root.left == null) return root;

        root.left.next = root.right;
        if(root.next!=null) root.right.next = root.next.left;
        connectPerfect(root.left);
        connectPerfect(root.right);
        return root;

    }

    public Node connect(Node root){
        if(root == null) return null;
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node curr = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                if(curr!=null) curr.next = node;
                curr = node;
            }
        }
        return root;
    }

    public Node connect2(Node root){
        if(root == null ) return root;
        Node currHead = root;
        Node nextLevelHead = getNextLevelHead(root);
        while (nextLevelHead!=null) {
            Node nextLevelCurr = nextLevelHead;
            while (currHead != null){
                if(currHead.left != null && nextLevelCurr != currHead.left) {
                    nextLevelCurr.next = currHead.left;
                    nextLevelCurr = nextLevelCurr.next;
                }
                if(currHead.right!= null && nextLevelCurr != currHead.right) {
                    nextLevelCurr.next = currHead.right;
                    nextLevelCurr = nextLevelCurr.next;
                }
                currHead = currHead.next;
            }
            currHead = nextLevelHead;
            nextLevelHead = getNextLevelHead(nextLevelHead);
        }
        return root;
    }

    private Node getNextLevelHead(Node currHead){
        while (currHead!=null){
            if(currHead.left != null) return currHead.left;
            if(currHead.right!=null) return currHead.right;
            currHead = currHead.next;
        }
        return null;
    }

}
