package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L90子集II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new LinkedList<>(), res);
        return res;
    }

    void backtrack(int[] nums, int start, LinkedList<Integer> current, List<List<Integer>> res ){
        res.add(new ArrayList<>(current));

        for (int i = start; i <nums.length ; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            current.add(nums[i]);
            backtrack(nums, i+1, current, res);
            current.removeLast();
        }
    }
}
