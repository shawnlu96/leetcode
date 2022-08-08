package com.sunstriker.jzoffer;

public class JZ66构建乘积数组 {
    public int[] multiply(int[] A) {
        int[] res = new int[A.length];
        res[0] = 1;
        for (int i = 1; i < A.length; i++) {
            res[i] = res[i-1] * A[i-1];
        }
        int temp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            temp *= A[i+1];
            res[i] *= temp;
        }
        return res;
    }
}
