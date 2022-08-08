package com.sunstriker.leetcode;

public class L26删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        int curr = 0, finder = 0;
        while (finder < nums.length){
            if(nums[finder]!= nums[curr]){
                nums[++curr] = nums[finder];
            }
            finder++;
        }
        return curr+1;
    }
}
