package com.sunstriker.jzoffer;

import com.sunstriker.structure.TreeNode;

import java.util.ArrayList;

public class JZ84FindPath3 {
    int count = 0;
    public static void main(String[] args) {
        var root = TreeNode.Deserialize("0,1,1");
        root.printTree();
        System.out.println(new JZ84FindPath3().FindPath(root, 6));
    }
    public int FindPath (TreeNode root, int sum) {
        // write code here
        if(root == null) return 0;
        ArrayList<Integer> pastNodes = new ArrayList<>();
        FindPath(root, pastNodes, sum);
        return count;
    }

    public void FindPath(TreeNode root, ArrayList<Integer> pastNodes, int target){
        int currSum = 0;
        ArrayList<Integer> targets = new ArrayList<>();
        targets.add(target);
        for (int i = pastNodes.size() - 1; i >= 0; i--) {
            currSum += pastNodes.get(i);
            targets.add(0, target-currSum);
        }
        for (Integer num : targets) {
            if(num == root.val) count++;
        }

        pastNodes = new ArrayList<>(pastNodes);
        pastNodes.add(root.val);
        if(root.left != null) {
            FindPath(root.left, pastNodes, target);
        }
        if(root.right != null) {
            FindPath(root.right, pastNodes, target);
        }
        pastNodes.remove(root);
    }

}
