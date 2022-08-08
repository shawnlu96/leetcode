package com.sunstriker.jzoffer;



public class JZ8GetNextNode {
    private class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    TreeLinkNode res = null;
    boolean pNodeVisited;
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null) return null;
        TreeLinkNode root = pNode;
        while(root.next != null){
            root = root.next;
        }
        GetNextPreOrder(root, pNode);
        return res;
    }
    public void GetNextPreOrder(TreeLinkNode root,TreeLinkNode pNode){
        if(root.left!=null) GetNextPreOrder(root.left, pNode);
        // what to do
        if(root == pNode) {
            pNodeVisited = true;
        }
        else {
            if (pNodeVisited && res == null) {
                res = root;
                return;
            }
        }
        if(root.right!= null) GetNextPreOrder(root.right, pNode);
    }
}
