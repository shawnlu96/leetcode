package com.sunstriker.leetcode;

public class L33搜索旋转排序数组 {
    public static void main(String[] args) {
        System.out.println(new L33搜索旋转排序数组().search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    int startingIndex = 0;
    int[] nums;

    public int search(int[] nums, int target) {
        this.nums = nums;
        startingIndex = getStartIndex(nums);
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int m = (l + r) / 2;
            if(getLeastKNum(m) == target) return (m + startingIndex) % nums.length;
            else if(getLeastKNum(m) > target) r = m-1;
            else l = m + 1;
        }
        return -1;
    }

    private int getStartIndex(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (r + l) / 2;
            if (nums[l] <= nums[m] && nums[m] < nums[r]) return l;
            if (nums[l] > nums[m]) r = m;
            else l = m + 1;
        }
        return l;
    }

    private int getLeastKNum(int k) {
        int index = k + startingIndex;
        if (index > nums.length - 1) index = index % nums.length;
        return nums[index];
    }

}
