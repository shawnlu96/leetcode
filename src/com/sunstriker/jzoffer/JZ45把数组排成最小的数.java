package com.sunstriker.jzoffer;

import java.util.Arrays;

public class JZ45把数组排成最小的数 {
    public String PrintMinNumber(int [] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (s1,s2) -> {
            String c1 = s1+s2, c2 = s2+s1;
            long l1 = Long.parseLong(c1), l2 = Long.parseLong(c2);
            return l1 == l2?0:(l1 > l2 ?1:0);
        });
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }
}
