package com.sunstriker.leetcode;

public class L240搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = n - 1, y = 0;
        while (x >=0 && y < m) {
            int curr  = matrix[y][x];
            if(target > curr) y++;
            else if(target < curr) x--;
            else return true;
        }
        return false;
    }
}
