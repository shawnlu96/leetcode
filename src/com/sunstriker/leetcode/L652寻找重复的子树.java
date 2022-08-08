package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L652寻找重复的子树 {
    HashMap<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    public String traverse(TreeNode root) {
        if (root == null) return "#";
        String left = traverse(root.left);
        String right = traverse(root.right);
        String str = left + "," +  right  + "," + root.val;
        Integer occurrence = map.getOrDefault(str, 0);
        map.put(str, occurrence + 1);
        if (occurrence == 1) {
            res.add(root);
        }
        return str;
    }
}
