package com.sunstriker.sort;

import com.sunstriker.structure.TreeNode;

import java.util.Stack;

public class HeapSort {
    public static void main(String[] args) {
        var arr = new int []{3,2,1,5,9,7,4};
        heapSort(arr);
    }
    public static int[] heapSort(int[] arr) {
        int length = arr.length;
        if(length<2) return arr;
        printCurrentState(arr);
        buildMaxHeap(arr);
        while (length>0){
            swap(arr,0, length-1);
            length--;
            heapify(arr, 0, length);
        }
        return arr;
    }

    public static void buildMaxHeap(int[] array){
        for (int i = array.length/2-1; i >=0 ; i--) {
            heapify(array, i, array.length);
        }
    }

    public static void heapify(int[] array, int parentIndex, int length) {
        System.out.println("before:");
        printCurrentState(array);
        int leftIndex = 2 * parentIndex + 1;
        int rightIndex = 2 * parentIndex + 2;
        int maxIndex = parentIndex;
        if (leftIndex < length && array[leftIndex] > array[maxIndex]) maxIndex = leftIndex;
        if (rightIndex < length && array[rightIndex] > array[maxIndex]) maxIndex = rightIndex;
        // 若产生了交换
        if(maxIndex != parentIndex){
            swap(array, maxIndex, parentIndex);
            // 重新构建调整
            heapify(array, maxIndex, length);
        }
        System.out.println("after:");
        printCurrentState(array);

    }

    public static void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void printCurrentState (int[] arr) {
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> si = new Stack<>();
        TreeNode root = new TreeNode(arr[0]);
        s.push(root);
        si.push(0);
        while (!s.isEmpty()){
            TreeNode node = s.pop();
            int index = si.pop();
            int leftChildIndex = index *2 +1;
            int rightChildIndex = index *2 +2;
            if(leftChildIndex<arr.length) {
                node.left = new TreeNode(arr[leftChildIndex]);
                s.push(node.left);
                si.push(leftChildIndex);
            }
            if(rightChildIndex<arr.length) {
                node.right = new TreeNode(arr[rightChildIndex]);
                s.push(node.right);
                si.push(rightChildIndex);
            }
        }
        root.printTree();
    }
}
