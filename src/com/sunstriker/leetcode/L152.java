package com.sunstriker.leetcode;

public class L152 {
    public int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int maxProduct = currMax;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < 0){
                int temp = 0;
                temp = currMax;
                currMax = currMin;
                currMin = temp;
            }
            currMax = Math.max(currMax*nums[i], nums[i]);
            currMin = Math.min(currMin*nums[i], nums[i]);

            maxProduct = Math.max(currMax, maxProduct);
        }
        return maxProduct;

    }
}
