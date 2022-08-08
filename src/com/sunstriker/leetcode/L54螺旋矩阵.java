package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L54螺旋矩阵 {
    public static void main(String[] args) {

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int capacity = m * n;
        List<Integer> res = new ArrayList<>(capacity);
        int left = 0, up = 0, down = m-1, right = n-1;
        int direction = 0;
        while (res.size() < capacity){
            switch (direction % 4) {
                case 0 -> {
                    for (int i = left; i <= right; i++) {
                        res.add(matrix[up][i]);
                    }
                    up++;
                }
                case 1 -> {
                    for (int i = up; i <= down; i++) {
                        res.add(matrix[i][right]);
                    }
                    right--;
                }
                case 2 -> {
                    for (int i = right; i >= left; i--) {
                        res.add(matrix[down][i]);
                    }
                    down--;
                }
                case 3 -> {
                    for (int i = down; i >= up; i--) {
                        res.add(matrix[i][left]);
                    }
                    left++;
                }
            }
            direction++;
        }
        return res;
    }
}
