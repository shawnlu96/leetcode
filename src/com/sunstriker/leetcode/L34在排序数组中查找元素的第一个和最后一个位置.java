package com.sunstriker.leetcode;

public class L34在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0,  right = nums.length-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] < target) {
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid -1;
            }else{
                right = mid -1;
            }
        }
        if(left == nums.length || nums[left]!=target) return new int[]{-1,-1};
        int newLeft = left, newRight = nums.length-1;
        while (newLeft<=newRight){
            int mid = newLeft + (newRight-newLeft)/2;
            if(nums[mid]< target){
                newLeft = mid+1;
            }else if (nums[mid] > target){
                newRight = mid -1;
            }else {
                newLeft = mid +1;
            }
        }
        return new int[]{left, newLeft-1};
    }
}
