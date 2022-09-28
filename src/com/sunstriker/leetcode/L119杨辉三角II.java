package com.sunstriker.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class L119杨辉三角II {
    public List<Integer> getRow(int rowIndex) {
        int[] arr = new int[rowIndex+1];

        for (int i = 0; i <= rowIndex; i++) {
            arr[0] = 1;
            arr[i] = 1;
            int temp = 1;
            for (int j = 1; j<i; j++){
                int res = arr[j] + temp;
                temp = arr[j];
                arr[j] = res;
            }
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList());

    }
}
