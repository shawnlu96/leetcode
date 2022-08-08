package com.sunstriker.jzoffer;

import com.sunstriker.structure.TreeNode;

import java.util.Stack;

public class JZ54KthNodeInBST
{
    public int KthNode (TreeNode proot, int k) {
        // write code here
        if(proot == null) return -1;
        int currRank = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = proot;
        while (curr != null || !stack.isEmpty()){
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if(++currRank ==k) return curr.val;
            curr = curr.right;
        }
        return -1;
    }
}
