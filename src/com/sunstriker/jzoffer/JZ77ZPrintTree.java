package com.sunstriker.jzoffer;

import com.sunstriker.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JZ77ZPrintTree {
    public static void main(String[] args) {
        var root = TreeNode.generateByRow(new Integer[]{1,2,3,null,null,4,5});
        System.out.println(Print(root));
    }
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) return new ArrayList<>();
        int currLength = 1, nextLength = 0;
        boolean isReversal = false;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> currList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (isReversal) currList.add(0, node.val);
            else currList.add(node.val);
            currLength--;
            if (node.left != null) {
                queue.offer(node.left);
                nextLength++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLength++;
            }
            if (currLength == 0) {
                isReversal = !isReversal;
                currLength = nextLength;
                nextLength = 0;
                res.add(currList);
                currList = new ArrayList<>();
            }
        }
        return res;
    }
}
