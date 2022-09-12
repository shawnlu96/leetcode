package com.sunstriker.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.locks.ReentrantLock;

public class L452用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        if(points.length < 2) return 1;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int[] last = null;
        int count = 1;
        for (int[] point : points) {
            if(last == null) last = point;
            else {
                if(point[0] > last[1]) {
                    count ++;
                    last = point;
                }
            }
        }
        return count;
    }
}
