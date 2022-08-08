package com.sunstriker.structure;

import java.util.*;

public class TreeNode {

    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(){}
    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode generateExampleBinarySearchTree() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(14);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        return root;
    }

    public static TreeNode generateByRow(Integer[] nums){
        if(nums.length == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(  nums[0]);
        queue.offer(root);
        while (index<nums.length){
            if(++index >= nums.length) return root;
            TreeNode node = queue.poll();
            Integer leftChild = nums[index];
            if(leftChild!=null){
                node.left = new TreeNode(leftChild);
                queue.offer(node.left);
            }
            if(++index >= nums.length) return root;
            Integer rightChild = nums[index];
            if(rightChild!=null) {
                node.right = new TreeNode(rightChild);
                queue.offer(node.right);
            }
        }
        return root;
    }

    public String Serialize(){
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
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

    public static TreeNode Deserialize(String str) {
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

    public static int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right));
    }

    private static String traversePreOrder(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        String pointerRight = "└──";
        String pointerLeft;
        if (root.right != null) {
            pointerLeft = "├──";
        } else {
            pointerLeft = "└──";
        }

        traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
        traverseNodes(sb, "", pointerRight, root.right, false);

        return sb.toString();
    }

    private static void traverseNodes(StringBuilder sb, String padding, String pointer, TreeNode node,
                                      boolean hasRightSibling) {
        if (node == null) {
            return;
        }

        sb.append("\n");
        sb.append(padding);
        sb.append(pointer);
        sb.append(node.val);

        StringBuilder paddingBuilder = new StringBuilder(padding);
        if (hasRightSibling) {
            paddingBuilder.append("│  ");
        } else {
            paddingBuilder.append("   ");
        }

        String paddingForBoth = paddingBuilder.toString();
        String pointerRight = "└──";
        String pointerLeft = (node.right != null) ? "├──" : "└──";

        traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
        traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
    }

    public static void printTreeHorizontal(TreeNode root) {
        System.out.print(traversePreOrder(root));
    }

    public  void printTree() {
        int maxLevel = getTreeDepth(this);
        printNodeInternal(Collections.singletonList(this), 1, maxLevel);
    }

    private  void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes == null || nodes.isEmpty() || isAllElementsNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<TreeNode>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(i + i - 1);
                if (nodes.get(j).right != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(1);
                }
                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
