package com.sunstriker.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class L435无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length < 2) return 0;
        int res = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int[] last = null;
        for (int[] interval : intervals) {
            if(last == null) {
                last = interval;
                continue;
            }
            if(interval[0] < last[1]) res++;
            else last = interval;
        }
        return res;
    }
}
