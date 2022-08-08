package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

public class L108将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        var res = new L108将有序数组转换为二叉搜索树().sortedArrayToBST(new int[]{-10,-3,0,5,9});
        res.printTree();
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    public TreeNode helper(int[] nums, int start, int end){
        if(end - start == 0) return new TreeNode(nums[start]);
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if(start < mid) root.left = helper(nums, start, mid-1);
        root.right = helper(nums, mid+1, end);
        return root;
    }
}
