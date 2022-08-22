package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

public class L337打家劫舍III {
    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0],res[1]);
    }

    public int[] dp(TreeNode root){
        if (root == null) return new int[]{0,0};
        int[] leftRes = dp(root.left);
        int[] rightRes = dp(root.right);
        int robCurr = root.val + leftRes[0] + rightRes[0];
        int notRobCurr = Math.max(leftRes[0], leftRes[1]) + Math.max(rightRes[0], rightRes[1]);
        return new int[]{notRobCurr, robCurr};
    }
}
