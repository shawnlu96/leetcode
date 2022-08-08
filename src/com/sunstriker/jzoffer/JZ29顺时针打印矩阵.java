package com.sunstriker.jzoffer;

import java.util.ArrayList;

public class JZ29顺时针打印矩阵 {
    public static void main(String[] args) {
        var m = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println(new JZ29顺时针打印矩阵().printMatrix(m));
    }
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int up = 0, left = 0, right = matrix[0].length - 1, down = matrix.length - 1;
        int x = 0, y = 0, count = 0;
        while (res.size() < matrix.length * matrix[0].length) {
            switch (count % 4) {
                case 0:
                    while (y <= right) {
                        res.add(matrix[x][y++]);
                    }
                    y--;
                    x++;
                    up++;
                    break;
                case 1:
                    while (x <= down) {
                        res.add(matrix[x++][y]);
                    }
                    x--;
                    y--;
                    right--;
                    break;
                case 2:
                    while (y >= left) {
                        res.add(matrix[x][y--]);
                    }
                    y++;
                    x--;
                    down--;
                    break;
                case 3:
                    while (x >= up) {
                        res.add(matrix[x--][y]);
                    }
                    x++;
                    y++;
                    left++;
                    break;
            }
            count++;
        }
        return res;
    }
}
