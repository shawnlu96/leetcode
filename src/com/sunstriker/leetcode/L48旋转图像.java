package com.sunstriker.leetcode;

public class L48旋转图像 {
    public static void main(String[] args) {
        var m = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        new L48旋转图像().rotate(m);
        new L48旋转图像().print(m);
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = n-1; i >0 ; i--) {
            int y = n-1-i, x = i;
            for (int j = 1; j <= i; j++) {
                int temp = matrix[y+j][x];
                matrix[y+j][x] = matrix[y][x-j];
                matrix[y][x-j] = temp;
            }
        }

        int l = 0, r = n-1;
        while (l<r){
            int[] temp = matrix[l];
            matrix[l] = matrix[r];
            matrix[r] = temp;
            l++;
            r--;
        }
    }

    public void print(int[][] matrix){
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
