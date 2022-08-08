package com.sunstriker.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class L757设置交集大小至少为2 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1,5},{2,6},{5,7},{6,8}};
        System.out.println(new L757设置交集大小至少为2().intersectionSizeTwoBad(a));
    }

    // 从后往前
    public int intersectionSizeTwo(int[][] intervals) {
        if (intervals.length == 1) return 2;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = intervals.length;
        int a = intervals[n - 1][0], b = intervals[n - 1][0] + 1, sum = 2;
        for (int i = n - 2; i >= 0; i--) {
            if (intervals[i][1] >= b) continue;
            if (intervals[i][1] < a) {
                a = intervals[i][1] - 1;
                b = a + 1;
                sum+=2;
            }else{
                b = a;
                a =  intervals[i][0];
                sum++;
            }
        }
        return sum;
    }

    //从前往后
    public int intersectionSizeTwoBad(int[][] intervals) {
        if (intervals.length == 1) return 2;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int lastIndex = -1;
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i] == null) continue;
            if (lastIndex == -1) lastIndex = i;
            int nextIndex = i + 1;
            while (intervals[nextIndex] == null) nextIndex++;
            if (intervals[i][1] >= intervals[nextIndex][1]) {
                intervals[i] = null;
                i = -1;
                lastIndex = -1;
            }
        }
        int sum = 2;
        if (lastIndex == -1) return 2;
        int a = intervals[lastIndex][1] - 1;
        int b = intervals[lastIndex][1];
        for (int i = lastIndex + 1; i < intervals.length; i++) {
            if (intervals[i] == null) continue;
            if (intervals[i][0] > intervals[lastIndex][1]) {
                a = intervals[i][1] - 1;
                b = intervals[i][1];
                sum += 2;
            } else if (intervals[i][0] == intervals[lastIndex][1]) {
                if (b != intervals[i][0]) {
                    a = intervals[i][1] - 1;
                    b = intervals[i][1];
                    sum += 2;
                } else {
                    a = b;
                    b = intervals[i][1];
                    sum++;
                }
            } else {
                if (b < intervals[i][0]) {
                    b = intervals[i][1];
                    a = b - 1;
                    sum += 2;
                } else if (a < intervals[i][0]) {
                    a = b;
                    b = intervals[i][1];
                    sum++;
                }
            }
            lastIndex = i;

        }
        return sum;
    }
}
