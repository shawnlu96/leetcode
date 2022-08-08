package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

public class L230二叉搜索树中第K小的元素 {
    int currRank = 0;
    Integer res = null;
    public int kthSmallest(TreeNode root, int k) {
        traversal(root,k);
        return res;
    }

    public void traversal(TreeNode root, int k){
        if(res != null || root == null)  return;
        traversal(root.left,k);
        if(++currRank == k) {
            res = root.val;
        }
        traversal(root.right,k);
    }
}
