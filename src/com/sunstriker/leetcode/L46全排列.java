package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L46全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new LinkedList<>(), new boolean[nums.length], res);
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> curr, boolean[] used, List<List<Integer>> res){
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if(used[i]) continue;
                used[i] = true;
                curr.add(nums[i]);
                backtrack(nums, curr, used, res);
                used[i] = false;
                curr.removeLast();
            }
        }
    }
}
