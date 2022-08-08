package com.sunstriker.leetcode;

public class L918 {
    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{-2, -3, -1}));
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int maxSum = nums[0];
        int minSum = nums[0];
        int allSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            allSum += nums[i];
            currMax = nums[i] + (currMax > 0 ? currMax : 0);
            currMin = nums[i] + (currMin < 0 ? currMin : 0);
            maxSum = currMax > maxSum ? currMax : maxSum;
            minSum = currMin < minSum ? currMin : minSum;
        }
        // 如果所有数都小于0，这里不考虑两端的情况
        if (maxSum < 0) return maxSum;

        return Math.max(maxSum, allSum - minSum);
    }
}
