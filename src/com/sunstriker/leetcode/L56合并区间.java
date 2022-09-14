package com.sunstriker.leetcode;

import java.util.*;

public class L56合并区间 {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(i-> i[0]));
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] merged = res.getLast();
            int[] curr = intervals[i];
            if(curr[0] <= merged[1]) merged[1] = Math.max(merged[1], curr[1]);
            else{
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
