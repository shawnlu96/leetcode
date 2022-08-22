package com.sunstriker.leetcode;

public class L198打家劫舍 {
    // dp
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int secondLast = nums[0];
        int last = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n ; i++) {
            int temp = last;
            last = Math.max(secondLast + nums[i], last);
            secondLast = temp;
        }
        return last;
    }
}
