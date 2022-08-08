package com.sunstriker.jzoffer;

import com.sunstriker.structure.TreeNode;

import java.util.ArrayList;

public class JZ86LowestCommonAncestor {
    ArrayList<TreeNode> o1path = new ArrayList<>();
    ArrayList<TreeNode> o2path = new ArrayList<>();
    TreeNode lowest;

    public static void main(String[] args) {
        var root = TreeNode.Deserialize("27,32,34,19,41,17,18,9,14,44,39,#,#,24,30,#,#,#,2,7,42,28,36,#,#,11,6,#,1,#,#,#,31,16,4,22,33,#,#,#,5,10,15,37,12,8,#,35,3,#,23,21,#,#,#,29,#,#,#,40,#,#,#,#,#,#,#,#,#,13,43,#,#,#,#,#,#,25,20,#,#,38,#,26");
        System.out.println(new JZ86LowestCommonAncestor().lowestCommonAncestor(root, 32, 38));
    }

    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        dfs(root, new ArrayList<>(), o1, o2);
        int i = 0;
        while (i< o1path.size() && i<o2path.size() && o1path.get(i) == o2path.get(i)){
            i++;
        }
        return o1path.get(i-1).val;
    }

    public void dfs(TreeNode root, ArrayList<TreeNode> path, int o1, int o2){
        if(!o1path.isEmpty() && !o2path.isEmpty()) return;
        path.add(root);
        if(root.val == o1){
            o1path.addAll(path);
        }
        if(root.val == o2){
            o2path.addAll(path);
        }
        if(root.left != null) dfs(root.left, path,o1, o2);
        if(root.right != null) dfs(root.right, path,o1,o2);
        path.remove(path.size()-1);
    }


}
