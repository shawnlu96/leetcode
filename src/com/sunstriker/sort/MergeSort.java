package com.sunstriker.sort;

public class MergeSort {
    public static int[] mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSortCore(nums, 0, nums.length-1, temp);
        return nums;
    }

    private static void mergeSortCore(int[] nums, int left, int right, int[] temp) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSortCore(nums, left, mid, temp);
        mergeSortCore(nums, mid + 1, right, temp);
        merge(nums, left, mid, right, temp);
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, index = 0;
        while (i<=mid && j<=right){
            if(nums[i]<nums[j]) temp[index++] = nums[i++];
            else temp[index++] = nums[j++];
        }
        while (i<=mid) temp[index++] = nums[i++];
        while (j<=right) temp[index++] = nums[j++];
        index = 0;
        while(left<=right){
            nums[left++] = temp[index++];
        }
    }
}
