package com.sunstriker.leetcode;

public class L27移除元素 {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if(nums[fast] == val){
                fast ++;
            }else {
                nums[slow++] = nums[fast++];
            }
        }
        return slow;
    }
}
