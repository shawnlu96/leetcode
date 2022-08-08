package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

import java.util.Arrays;

public class L297二叉树的序列化与反序列化 {
    // Encodes a tree to a single string.
    public static void main(String[] args) {
        var root = TreeNode.generateByRow(new Integer[]{1,2,3,null,null,4,5,6,7});
        root.printTree();
        var o = new L297二叉树的序列化与反序列化();
        var str = o.serialize(root);
        System.out.println(str);
        var res = o.deserialize(str);
        res.printTree();
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    public void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('#').append(',');
            return;
        }
        sb.append(root.val).append(',');
        helper(root.left, sb);
        helper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Integer[] nums = Arrays.stream(data.split(",")).map(str -> str.equals("#") ? null : Integer.parseInt(str) ).toArray(Integer[]::new);
        return builder(nums);
    }

    int startingIndex = 0;
    public TreeNode builder(Integer[] nums){
        if(startingIndex >= nums.length-1) return null;

        Integer first = nums[startingIndex++];
        if(first == null) return null;
        TreeNode root = new TreeNode(first);
        root.left = builder(nums);
        root.right = builder(nums);
        return root;
    }
}
