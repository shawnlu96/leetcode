package com.sunstriker.jzoffer;

import com.sunstriker.sort.MergeSort;

public class JZ51数组中的逆序对 {
    public static void main(String[] args) {
        var arr = new int[]{1,2,3,4,5,6,7,0};
        System.out.println(new JZ51数组中的逆序对().InversePairs(arr));
    }
    int count = 0;
    public int InversePairs(int [] array) {
        int[] temp = new int[array.length];
        mergeSortCore(array, 0, array.length-1, temp);
        return count % 1000000007;
    }
    private  int[] mergeSortCore(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortCore(nums, left, mid, temp);
            mergeSortCore(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
        return nums;
    }
    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, index = 0;
        while (i<=mid && j<=right){
            if(nums[i]<nums[j]) temp[index++] = nums[i++];
            else {
                temp[index++] = nums[j++];
                count+= mid-i+1;
                count %= 1000000007;
            }
        }
        while (i<=mid) temp[index++] = nums[i++];
        while (j<=right) temp[index++] = nums[j++];
        index = 0;
        while(left<=right){
            nums[left++] = temp[index++];
        }
    }


}
