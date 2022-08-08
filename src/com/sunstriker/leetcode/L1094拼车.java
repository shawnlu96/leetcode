package com.sunstriker.leetcode;

import java.util.HashMap;

public class L1094拼车 {
    public static void main(String[] args) {
        int a = 1;
        Integer b = 1;
        System.out.println(a == b);

    }
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }
        int curr = 0;
        for (int i = 0; i < diff.length; i++) {
            curr += diff[i];
            if(curr > capacity) return false;
        }
        return true;
    }
}
