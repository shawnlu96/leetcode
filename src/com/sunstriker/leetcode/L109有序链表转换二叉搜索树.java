package com.sunstriker.leetcode;

import com.sunstriker.structure.ListNode;
import com.sunstriker.structure.TreeNode;

import java.util.LinkedList;

public class L109有序链表转换二叉搜索树 {
    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<>();
        a.push(1);
        a.push(2);
        a.push(3);
        a.pop();
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode curr = head;
        int count = 0;
        while (curr !=null){
            curr = curr.next;
            count++;
        }
        TreeNode root = buildTree(count);
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()){
            while (node!=null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            node.val = head.val;
            head = head.next;
            node = node.right;
        }
        return root;

    }

    public void test(int a, char... b){
        char[] aa = b;

    }

    public TreeNode buildTree(int count){
        TreeNode root = new TreeNode();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        count--;
        while (count > 0){
            TreeNode node =  queue.poll();
            node.left = new TreeNode();
            queue.offer(node.left);
            if(--count > 0){
                node.right = new TreeNode();
                queue.offer(node.right);
                count --;
            }
        }
        return root;
    }
}
