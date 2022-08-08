package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L797所有可能的路径 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        traverse(graph, 0, new ArrayList<>());
        return res;
    }

    public void traverse(int[][] graph, int i, ArrayList<Integer> path){
        path.add(i);
        int n = graph.length;
        if(i == n-1){
            res.add(new ArrayList<>(path));
        }
        for (int p : graph[i]) {
            traverse(graph, p ,path);
        }
        path.remove(path.size()-1);
    }
}
