package com.sunstriker.jzoffer;

public class JZ81调整数组顺序使奇数位于偶数前面2 {
    public int[] reOrderArrayTwo(int[] array) {
        // write code here
        int lastOddIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                if(i != ++lastOddIndex){
                    int temp = array[lastOddIndex];
                    array[lastOddIndex] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
}
