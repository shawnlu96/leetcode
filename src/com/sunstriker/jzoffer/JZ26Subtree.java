package com.sunstriker.jzoffer;

import com.sunstriker.structure.TreeNode;

public class JZ26Subtree {
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.generateByRow(new Integer[]{1, 2, 3, 4, 5});
        TreeNode root2 = TreeNode.generateByRow(new Integer[]{1, 2, 3});
        System.out.println(hasSubtree(root1, root2));
    }

    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return isSubtree(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    public static boolean isSubtree(TreeNode node1, TreeNode node2) {
        if(node2 == null) return  true;
        if(node1 == null ) return false;
        if(node1.val!=node2.val) return false;
        return isSubtree(node1.left, node2.left) && isSubtree(node1.right, node2.right);
    }
}
