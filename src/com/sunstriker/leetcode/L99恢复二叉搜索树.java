package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

import java.util.Stack;

public class L99恢复二叉搜索树 {
    /**
     * 中序遍历，找出逆序对，如果只有 一个则交换，如有两个，则交换第一个逆序对的首个跟第二个逆序对的第二个
     * @param root
     */
    public void recoverTree(TreeNode root) {
        TreeNode r1 = null, r2 = null, r3 = null, r4 = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(r1 == null) r1= curr;
            else{
                if(r2 == null){
                    if(curr.val< r1.val){
                        r2 = curr;
                        r3 = curr;
                    }else {
                        r1= curr;
                    }
                }else{
                    if(curr.val < r3.val){
                        r4 = curr;
                        break;
                    }else {
                        r3 = curr;
                    }
                }
            }
            curr = curr.right;
        }
        if(r4!=null) r2 = r4;
        int temp = r2.val;
        r2.val = r1.val;
        r1.val = temp;
    }
}
