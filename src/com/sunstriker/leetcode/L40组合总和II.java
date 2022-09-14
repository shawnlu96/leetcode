package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L40组合总和II {
    public static void main(String[] args) {
        System.out.println(new L40组合总和II().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
    int target;
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.target = target;
        backTrack(candidates, 0, 0);
        return res;
    }

    void backTrack(int[] candidates,int start, int currSum){
        if(currSum > target) return;
        if(currSum == target) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <candidates.length ; i++) {
            if(i > start && candidates[i] == candidates[i-1]) continue;
            track.add(candidates[i]);
            backTrack(candidates, i+1, currSum+candidates[i]);
            track.removeLast();
        }
    }
}
