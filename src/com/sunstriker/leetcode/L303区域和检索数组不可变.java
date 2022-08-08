package com.sunstriker.leetcode;

public class L303区域和检索数组不可变 {
    class NumArray {
        int[] sums;
        public NumArray(int[] nums) {
            sums = new int[nums.length+1];
            for (int i = 1; i < sums.length; i++) {
                sums[i] = sums[i-1] + nums[i-1];
            }
        }

        public int sumRange(int left, int right) {
            return sums[right+1] - sums[left];
        }
    }
}
