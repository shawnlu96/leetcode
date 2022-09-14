package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L77组合 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, 1, k, new LinkedList<>(), res);
        return res;
    }

    static void backtrack(int n, int start,int k, LinkedList<Integer> current, List<List<Integer>> res ){
        if(k==current.size()){
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <=n ; i++) {
            current.add(i);
            backtrack(n, i+1,k, current, res);
            current.removeLast();
        }
    }
}
