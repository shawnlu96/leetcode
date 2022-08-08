package com.sunstriker.jzoffer;

import com.sunstriker.structure.TreeNode;

import java.util.Stack;

public class JZ36BinarySearchTreeToDoubleLinkedList {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateExampleBinarySearchTree();
        TreeNode head = Convert(root);
        while (head != null){
            System.out.print(head.val + " ");
            head = head.right;
        }
    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = pRootOfTree;
        TreeNode prev = null;
        TreeNode head = null;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            TreeNode listNode = curr;
            curr = curr.right;
            // 这里对listNode进行节点转换相关操作
            if(prev != null){
                listNode.left = prev;
                prev.right = listNode;
            }else {
                head = listNode;
            }
            prev = listNode;

        }
        return head;
    }
}
