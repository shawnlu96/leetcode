package com.sunstriker.leetcode;

import java.util.Arrays;

public class L62不同路径 {
    public int uniquePaths(int m, int n) {
        int[][] tables = new int[m][n];
        Arrays.fill(tables[0], 1);
        for (int i = 0; i < m; i++) {
            tables[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                tables[i][j] = tables[i-1][j] + tables[i][j-1];
            }
        }
        return tables[m-1][n-1];
    }

}
