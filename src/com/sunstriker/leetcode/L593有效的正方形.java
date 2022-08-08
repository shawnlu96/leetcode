package com.sunstriker.leetcode;

import java.util.Arrays;

public class L593有效的正方形 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = new int[][]{p1, p2, p3, p4};
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return distancePow(points[0], points[1]) != 0
                && distancePow(points[0], points[1]) == distancePow(points[0], points[2])
                && distancePow(points[0], points[2]) == distancePow(points[3], points[2])
                && distancePow(points[3], points[2]) == distancePow(points[3], points[1])
                && distancePow(points[3], points[0]) == distancePow(points[1], points[2]);
    }

    private int distancePow(int[] p1, int[] p2) {
        return (int) (Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }
}
