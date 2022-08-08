package com.sunstriker.jzoffer;

import com.sunstriker.structure.TreeNode;

import java.util.ArrayList;

public class JZ34FindPath {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        if (root == null) return res;
        FindPath(root, expectNumber, path, res);
        return res;
    }

    public void FindPath(TreeNode root, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        path.add(root.val);
        // 如果该节点为叶子节点
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add(new ArrayList<>(path));
            }
            path.remove(path.size()-1);
            return;
        }
        if (root.left != null) FindPath(root.left, sum - root.val, path, res);
        if (root.right != null) FindPath(root.right, sum - root.val, path, res);
        path.remove(path.size()-1);
    }
}
