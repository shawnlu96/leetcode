package com.sunstriker.leetcode;

public class L1252奇数值单元格的数目 {
    public int oddCells(int m, int n, int[][] indices) {
        boolean[] row = new boolean[m], col = new boolean[n];
        for (int[] index : indices) {
            row[index[0]] = !row[index[0]];
            col[index[1]] = !col[index[1]];
        }
        int rc = 0, cc = 0;
        for (int i = 0; i < m; i++) {
            if (row[i]) rc++;
        }
        for (int i = 0; i < n; i++) {
            if (col[i]) cc++;
        }
        return rc * n + cc * m - 2 * rc * cc;

    }
}
