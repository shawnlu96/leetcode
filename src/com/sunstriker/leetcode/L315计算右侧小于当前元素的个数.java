package com.sunstriker.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class L315计算右侧小于当前元素的个数 {
    public static void main(String[] args) {
        var res = new L315计算右侧小于当前元素的个数().countSmaller(new int[]{-1,-1});
    }
    class Pair {
        int id, val;

        public Pair(int id, int val) {
            this.id = id;
            this.val = val;
        }
    }

    int[] count;

    public List<Integer> countSmaller(int[] nums) {
        count = new int[nums.length];
        Pair[] arr = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(i, nums[i]);
        }
        Pair[] temp = new Pair[nums.length];
        mergeSortCore(arr,  0, arr.length-1, temp );
        return Arrays.stream(count).boxed().toList();
    }

    private void mergeSortCore(Pair[] arr, int left, int right, Pair[] temp) {
        if (right <= left) return;
        int mid = left + (right - left) / 2;
        mergeSortCore(arr, left, mid, temp);
        mergeSortCore(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    private void merge(Pair[] arr, int left, int mid, int right, Pair[] temp) {
        int i = left, j = mid + 1, index = 0;
        while (i <= mid && j <= right) {
            if (arr[i].val <= arr[j].val) {
                temp[index++] = arr[i];
                count[arr[i].id] += j - mid - 1;
                i++;
            } else {
                temp[index++] = arr[j++];
            }
        }
        while (i <= mid){
            temp[index++] = arr[i];
            count[arr[i].id] += j - mid - 1;
            i++;
        }
        while (j <= right) temp[index++] = arr[j++];
        index = 0;
        while (left <= right){
            arr[left++] = temp[index++];
        }
    }
}
