package com.sunstriker.leetcode;

public class L283移动零 {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if(nums[fast]!=0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }
}
