package com.sunstriker.leetcode;

public class L213打家劫舍II {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(robRange(nums, 1, nums.length-1), robRange(nums, 0, nums.length-2));

    }

    public int robRange(int[] nums, int start, int end) {
        int n = end - start + 1;
        if(n == 1) return nums[start];
        int secondLast = nums[start];
        int last = Math.max(nums[start], nums[start+1]);
        for (int i = start+2; i <= end ; i++) {
            int temp = last;
            last = Math.max(secondLast + nums[i], last);
            secondLast = temp;
        }
        return last;
    }
}
