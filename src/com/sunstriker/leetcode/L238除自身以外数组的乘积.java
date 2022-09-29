package com.sunstriker.leetcode;

public class L238除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int temp = 1;
        for (int i = n - 2; i >= 0; i--) {
            temp *= nums[i+1];
            res[i] *= temp;
        }
        return res;
    }
}
