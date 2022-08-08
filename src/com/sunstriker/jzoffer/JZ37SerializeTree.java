package com.sunstriker.jzoffer;

import com.sunstriker.structure.TreeNode;

import java.util.LinkedList;

public class JZ37SerializeTree {
    public static void main(String[] args) {
        var o = new JZ37SerializeTree();
        var str = "5,4,#,3,#,2";
        var root = o.Deserialize(str);
        System.out.println(o.Serialize(root));
    }
    String Serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr!=null) {
                sb.append(curr.val+",");
                queue.offer(curr.left);
                queue.offer(curr.right);
            }else{
                sb.append("#,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        if(str.isEmpty()) return null;
        String[] strNums = str.split(",");
        Integer[] nums = new Integer[strNums.length];
        for (int i = 0; i < strNums.length; i++) {
            if(strNums[i].equals("#")) nums[i] = null;
            else nums[i] = Integer.parseInt(strNums[i]);
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);
        int index = 0;
        while (index < nums.length){
            if(++index >= nums.length) return root;
            TreeNode curr = queue.poll();
            Integer leftChild = nums[index];
            if(leftChild!=null) {
                curr.left = new TreeNode(nums[index]);
                queue.offer(curr.left);
            }
            if(++index >= nums.length) return root;
            Integer rightChild = nums[index];
            if(rightChild!=null) {
                curr.right = new TreeNode(nums[index]);
                queue.offer(curr.right);
            }
        }
        return root;
    }
}
