package com.sunstriker.jzoffer;

import java.util.ArrayList;

public class JZ40最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(k==0||input.length <k)  return res;
        buildMinHeap(input);
        int length = input.length;
        while (res.size()<k){
            res.add(input[0] );
            swap(input,  0, length-1);
            length--;
            heapify(input, 0, length);
        }
        return res;
    }
    public static void buildMinHeap(int[] array){
        for (int i = array.length/2-1; i >=0 ; i--) {
            heapify(array, i, array.length);
        }
    }

    public static void heapify(int[] array, int parentIndex, int length) {
        int leftIndex = 2 * parentIndex + 1;
        int rightIndex = 2 * parentIndex + 2;
        int minIndex = parentIndex;
        if (leftIndex < length && array[leftIndex] < array[minIndex]) minIndex = leftIndex;
        if (rightIndex < length && array[rightIndex] < array[minIndex]) minIndex = rightIndex;
        // 若产生了交换
        if(minIndex != parentIndex){
            swap(array, minIndex, parentIndex);
            // 重新构建调整
            heapify(array, minIndex, length);
        }

    }

    public static void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
