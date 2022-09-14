package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L39组合总和 {
    int target;
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        backtrack(candidates, 0, 0);
        return res;
    }

    void backtrack(int[] candidates,int start, int currentSum){
        if(currentSum > target) return;
        if(currentSum == target) {
            res.add(new ArrayList<>(track));
        }
        for (int i = start; i < candidates.length; i++) {
            track.add(candidates[i]);
            backtrack(candidates, i, currentSum+candidates[i]);
            track.removeLast();
        }

    }
}
