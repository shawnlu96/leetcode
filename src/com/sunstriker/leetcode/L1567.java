package com.sunstriker.leetcode;

public class L1567 {
    public static void main(String[] args) {
        System.out.println(getMaxLen(new int[]{0, 1, -2, -3, -4}));
    }

    public static int getMaxLen(int[] nums) {
        if (nums.length == 1) return nums[0] > 0 ? 1 : 0;
        int dpPositive = 0;
        int dpNegative = 0;
        int max = 0;
        dpPositive = nums[0] > 0 ? 1 : 0;
        dpNegative = nums[0] < 0 ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                dpPositive = 0;
                dpNegative = 0;
            } else {
                if (nums[i] > 0) {
                    dpPositive = dpPositive + 1;
                    dpNegative = dpNegative > 0 ? dpNegative + 1 : 0;
                } else {
                    int temp = 0;
                    temp = dpNegative;
                    dpNegative = dpPositive + 1;
                    dpPositive = temp > 0 ? temp + 1 : 0;
                }

            }
            max = Math.max(max, dpPositive);
        }

        return max;

    }
}
