package com.sunstriker.leetcode;

public class L53最大子数组和 {
    public int maxSubArray(int[] nums) {
        int last = nums[0];

        int res = last;
        for (int i = 1; i < nums.length; i++) {
            int curr = Math.max(last, 0) + nums[i];
            res = Math.max(res, curr);
            last = curr;
        }
        return res;
    }

    public int maxSubArray1(int[] nums) {
        int right = 0, res = Integer.MIN_VALUE, currSum = 0;
        while (right < nums.length){
            int n = nums[right++];
            currSum  = currSum < 0 ? n : currSum + n;
            res = Math.max(currSum, res);
        }
        return res;
    }
}
