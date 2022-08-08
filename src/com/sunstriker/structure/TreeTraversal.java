package com.sunstriker.structure;

import java.util.ArrayList;
import java.util.Stack;

public class TreeTraversal {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateExampleBinarySearchTree();
        System.out.println(PreOrder(root));
        System.out.println(InOrder(root));
        System.out.println(PostOrder(root));
    }

    public static ArrayList<Integer> PreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);

        }
        return res;
    }

    public static ArrayList<Integer> InOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            // 自己以及左边的节点依次入栈
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // 弹出最左边的节点
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public static ArrayList<Integer> PostOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode curr = null;

        stack.push(root);
        stack.push(root);
        while (!stack.isEmpty()){
            curr = stack.pop();
            if(!stack.isEmpty() && curr == stack.peek()){
                if(curr.right != null){
                    stack.push(curr.right);
                    stack.push(curr.right);
                }
                if(curr.left != null){
                    stack.push(curr.left);
                    stack.push(curr.left);
                }
            }else{
                res.add(curr.val);
            }
        }

        return res;
    }
}
