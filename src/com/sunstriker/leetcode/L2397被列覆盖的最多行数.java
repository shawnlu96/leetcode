package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L2397被列覆盖的最多行数 {
    public static void main(String[] args) {
//        System.out.println(new L2397被列覆盖的最多行数().maximumRows(new int[][]{{0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1}, {0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1}, {1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0}, {1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1}}, 3));
//       System.out.println(new L2397被列覆盖的最多行数().maximumRows(new int[][]{{0, 0, 0},{1,0,1},{0,1,1},{0,0,1}}, 2));
       var s = new L2397被列覆盖的最多行数();
       s.backTrack(3,0, 2);
    }
    int[] nums;
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length, n = matrix[0].length;
        nums = new int[m];
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int i1 : row) {
                nums[i] = nums[i] * 2 + i1;
            }
        }
        backTrack(n,0, numSelect);


        return maxCount;
    }

    int num = 0, maxCount = 0;
    private void backTrack(int n,int start, int numSelect) {
        if (numSelect == 0) {
            int count = 0;
            for (int na : nums) {
                if((na&num) == na) count++;
            }
            maxCount = Math.max(count, maxCount);
            return;
        }
        for (int i = start; i < n; i++) {
            num |= 1 << i;
            backTrack(n, i+1,numSelect - 1);
            num &= ~(1<<i);
        }
    }
}
